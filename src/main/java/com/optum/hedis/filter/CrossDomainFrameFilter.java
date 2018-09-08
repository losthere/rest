package com.optum.hedis.filter;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;

/**
 * @author
 *
 */
public class CrossDomainFrameFilter implements Filter {

	private static final String X_FRAME_OPTIONS = "X-Frame-Options";
	private String option = "DENY";

	public static final boolean APP_USE_WEBFONTS = false;
	public static final boolean APP_USE_AUDIOS_OR_VIDEOS = false;
	public static final boolean INCLUDE_MOZILLA_CSP_DIRECTIVES = true;

	private List<String> cspHeaders = new ArrayList<>();
	private String policies = null;
	private SecureRandom prng = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String xFrameOption = filterConfig.getInitParameter("mode");
		if (xFrameOption != null) {
			option = xFrameOption;
		}

		try {
			prng = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException(e);
		}

		cspHeaders.add("Content-Security-Policy");
		cspHeaders.add("X-Content-Security-Policy");
		cspHeaders.add("X-WebKit-CSP");

		// Define CSP policies
		List<String> cspPolicies = new ArrayList<>();
		String originLocationRef = "'self'";
		cspPolicies.add("default-src 'none'");
		cspPolicies.add("script-src " + originLocationRef + " 'unsafe-inline' 'unsafe-eval'");
		if (INCLUDE_MOZILLA_CSP_DIRECTIVES) {
			cspPolicies.add("options inline-script eval-script");
			cspPolicies.add("xhr-src 'self'");
		}
		cspPolicies.add("object-src " + originLocationRef);
		cspPolicies.add("style-src " + originLocationRef);
		cspPolicies.add("img-src " + originLocationRef);
		cspPolicies.add("form-action " + originLocationRef);
		if (APP_USE_AUDIOS_OR_VIDEOS) {
			cspPolicies.add("media-src " + originLocationRef);
		}
		if (APP_USE_WEBFONTS) {
			cspPolicies.add("font-src " + originLocationRef);
		}
		cspPolicies.add("connect-src " + originLocationRef);
		cspPolicies.add("plugin-types application/pdf application/x-shockwave-flash");
		cspPolicies.add("reflected-xss block");

		// Target formating
		policies = cspPolicies.toString().replaceAll("(\\[|\\])", "").replaceAll(",", ";").trim();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.addHeader(X_FRAME_OPTIONS, option);
		// Detect if target resource is a Frame - Customize here according to your context...
		// Add CSP policies to HTTP response
		StringBuilder policiesBuffer = new StringBuilder(policies);

		// If resource is a frame add Frame/Sandbox CSP policy
		policiesBuffer.append(";").append("frame-src 'self';sandbox");
		if (INCLUDE_MOZILLA_CSP_DIRECTIVES) {
			policiesBuffer.append(";").append("frame-ancestors 'self'");
		}

		// Add Script Nonce CSP Policy
		String randomNum = new Integer(this.prng.nextInt()).toString();
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException(e);
		}
		byte[] digest = sha.digest(randomNum.getBytes());
		String scriptNonce = Hex.encodeHexString(digest);
		policiesBuffer.append(";").append("script-nonce ").append(scriptNonce);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setAttribute("CSP_SCRIPT_NONCE", scriptNonce);

		// Add policies to all HTTP headers
		for (String header : this.cspHeaders) {
			httpResponse.setHeader(header, policiesBuffer.toString());
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Added a nested comment to avoid SONAR Issues
	}
}
