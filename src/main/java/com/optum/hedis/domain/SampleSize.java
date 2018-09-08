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
@Table(name = "NCQA_SAMPLE_SIZE")
public class SampleSize implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(generator = "Ncqa_Sample_Size_Seq")
	@SequenceGenerator(name = "Ncqa_Sample_Size_Seq", sequenceName = "NCQA_SAMPLE_SIZE_SEQ")
	@Column(name = "NCQA_SAMPLE_SIZE_SEQ")
	private long ncqaSampleSizeSeq;

	@Column(name = "MEASUREMENT_YR")
	private Long measurementYr;

	@Column(name = "MEASURE_DESC")
	private String measureDesc;
	
	@Column(name = "MEASURE_NAME")
	private String measureName;
	
	@Column(name = "MEDICAID")
	private Long medicaid;
	
	@Column(name = "COMMERCIAL")
	private Long commercial;

	@Column(name = "MEDICARE")
	private Long medicare;
	
	@Column(name = "PY_RATE")
	private Long pyRate;
	
	@Column(name = "RAND")
	private Long rand;
	
	@Column(name = "IS_ACTIVE")
	private Long isActive;
	
	@Column(name = "NOTE")
	private String note;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	public long getNcqaSampleSizeSeq() {
		return ncqaSampleSizeSeq;
	}

	public void setNcqaSampleSizeSeq(long ncqaSampleSizeSeq) {
		this.ncqaSampleSizeSeq = ncqaSampleSizeSeq;
	}

	public Long getMeasurementYr() {
		return measurementYr;
	}

	public void setMeasurementYr(Long measurementYr) {
		this.measurementYr = measurementYr;
	}

	public String getMeasureDesc() {
		return measureDesc;
	}

	public void setMeasureDesc(String measureDesc) {
		this.measureDesc = measureDesc;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public Long getMedicaid() {
		return medicaid;
	}

	public void setMedicaid(Long medicaid) {
		this.medicaid = medicaid;
	}

	public Long getCommercial() {
		return commercial;
	}

	public void setCommercial(Long commercial) {
		this.commercial = commercial;
	}

	public Long getMedicare() {
		return medicare;
	}

	public void setMedicare(Long medicare) {
		this.medicare = medicare;
	}

	public Long getPyRate() {
		return pyRate;
	}

	public void setPyRate(Long pyRate) {
		this.pyRate = pyRate;
	}

	public Long getRand() {
		return rand;
	}

	public void setRand(Long rand) {
		this.rand = rand;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
