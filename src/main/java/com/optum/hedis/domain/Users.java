package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="XWALK_USERS")

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(generator = "Users_Seq")
	@SequenceGenerator(name = "Users_Seq", sequenceName = "USERS_SEQ")
	@JsonInclude
	@Column(name = "USERS_SEQ")
	private long Users_Seq;
	
	@JsonInclude
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@JsonInclude
	@Column(name="USERNAME")
	private String username;
	
	@JsonInclude
	@Column(name="PASSWORD")
	private String password;
	
	@JsonInclude
	@Column(name="USERROLE")
	private String userrole;
	
	@JsonInclude
	@Column(name="IS_AUTHORIZE")
	private Long isAuthorize;
	
	@JsonInclude
	@Column(name="JUSTIFICATION")
	private String justification;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	public Long getIsAuthorize() {
		return isAuthorize;
	}

	public void setIsAuthorize(Long isAuthorize) {
		this.isAuthorize = isAuthorize;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

