package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OHM_MEAS_CODES")
public class MeasCodes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MeasCodesPK id;
	
	@Column(name="DESCR")
	private String descr;
	
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@Column(name="CLIENT_KEY")
	private Long clientKey;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT")
	private Date updateDt;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;

	public MeasCodesPK getId() {
		return id;
	}

	public void setId(MeasCodesPK id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Long getClientKey() {
		return clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}