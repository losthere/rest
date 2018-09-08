package com.optum.hedis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.optum.hedis.domain.Users;

@Component
public class EmailNotificationUtil {
	
	private JavaMailSender javaMailSender;
    
	@Autowired
	public EmailNotificationUtil(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}

	public void userLoginMail(Users userToAdd) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userToAdd.getEmailId());
		mail.setFrom("no-reply.hedis@optum.com");
		mail.setCc("shashidhar.bharadwaj@optum.com");
		mail.setSubject("X-Walk User Registration");
		mail.setText("Hello \n");
		mail.setText("Welcom to Xwalk Application\n");
		javaMailSender.send(mail);
	}
}

