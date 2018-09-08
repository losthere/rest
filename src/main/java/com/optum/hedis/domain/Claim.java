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
@Table(name="HDE_CLAIM_ID_XWALK")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Hde_Claim_Id_XWalk_Seq")
	@SequenceGenerator(name = "Hde_Claim_Id_XWalk_Seq", sequenceName = "HDE_CLAIM_ID_XWALK_SEQ")
	@Column(name="HDE_CLAIM_ID_XWALK_SEQ")
	private Long hdeClaimIdXWalkSeq;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@JsonInclude
	@Column(name="NUMERATOR_ID")
	private String numeratorId;
	
	@JsonInclude
	@Column(name="DEN_CLAIM_METRIC_CODE")
	private String denClaimMetricCode;
	
	@JsonInclude
	@Column(name="NUM_CLAIM_METRIC_CODE")
	private String numClaimMetricCode;
	
	@JsonInclude
	@Column(name="EXCLUSION_CLAIM_METRIC_CODE")
	private String exclusionClaimMetricCode;
	
	@JsonInclude
	@Column(name="REPORTING_YR")
	private Long reportingYr;
	
	public Long getHdeClaimIdXWalkSeq() {
		return hdeClaimIdXWalkSeq;
	}

	public void setHdeClaimIdXWalkSeq(Long hdeClaimIdXWalkSeq) {
		this.hdeClaimIdXWalkSeq = hdeClaimIdXWalkSeq;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getNumeratorId() {
		return numeratorId;
	}

	public void setNumeratorId(String numeratorId) {
		this.numeratorId = numeratorId;
	}

	public String getDenClaimMetricCode() {
		return denClaimMetricCode;
	}

	public void setDenClaimMetricCode(String denClaimMetricCode) {
		this.denClaimMetricCode = denClaimMetricCode;
	}

	public String getNumClaimMetricCode() {
		return numClaimMetricCode;
	}

	public void setNumClaimMetricCode(String numClaimMetricCode) {
		this.numClaimMetricCode = numClaimMetricCode;
	}

	public String getExclusionClaimMetricCode() {
		return exclusionClaimMetricCode;
	}

	public void setExclusionClaimMetricCode(String exclusionClaimMetricCode) {
		this.exclusionClaimMetricCode = exclusionClaimMetricCode;
	}

	public Long getReportingYr() {
		return reportingYr;
	}

	public void setReportingYr(Long reportingYr) {
		this.reportingYr = reportingYr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}