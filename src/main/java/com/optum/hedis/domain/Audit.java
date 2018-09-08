package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "XWALK_AUDIT")

public class Audit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TIMESTAMP")
	private String timestamp;
	
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "MEASURE")
	private String measure;
	
	@Column(name = "OPERATION")
	private String operation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
