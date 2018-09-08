package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SAMP_EM_IDSS_XWALK")
public class SampEmIdss implements Serializable {
	private static final long serialVersionUID = 1L;
     
	@Id
	@GeneratedValue(generator = "Samp_Em_Idss_Xwalk_Seq")
	@SequenceGenerator(name = "Samp_Em_Idss_Xwalk_Seq", sequenceName = "SAMP_EM_IDSS_XWALK_SEQ")
	@Column(name = "SAMP_EM_IDSS_XWALK_SEQ")
	private long sampEmIdssXwalkSeq;

	@Column(name = "MEASUREMENT_YR")
	private Long measurementYr;

	@Column(name = "MEASURE_NAME")
	private String measureName;
	
	@Column(name = "SAMP_IDSS_ELEMENT")
	private String sampIdssElement;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT")
	private Date updateDt;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public long getSampEmIdssXwalkSeq() {
		return sampEmIdssXwalkSeq;
	}

	public void setSampEmIdssXwalkSeq(long sampEmIdssXwalkSeq) {
		this.sampEmIdssXwalkSeq = sampEmIdssXwalkSeq;
	}

	public Long getMeasurementYr() {
		return measurementYr;
	}

	public void setMeasurementYr(Long measurementYr) {
		this.measurementYr = measurementYr;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getSampIdssElement() {
		return sampIdssElement;
	}

	public void setSampIdssElement(String sampIdssElement) {
		this.sampIdssElement = sampIdssElement;
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