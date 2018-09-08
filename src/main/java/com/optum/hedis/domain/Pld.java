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
@Table(name="HDE_PLD_MEAS_XWALK")
public class Pld implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Hde_Pld_Meas_XWalk_Seq")
	@SequenceGenerator(name = "Hde_Pld_Meas_XWalk_Seq", sequenceName = "HDE_PLD_MEAS_XWALK_SEQ")
	@JsonInclude
	@Column(name="HDE_PLD_MEAS_XWALK_SEQ")
	private Long hdePldMeasXWalkSeq;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@JsonInclude
	@Column(name="MEASURE_ID")
	private String measureId;
	
	@JsonInclude
	@Column(name="STRATIFICATION_ID")
	private String stratificationId;
	
	@JsonInclude
	@Column(name="DENOMINATOR_FLAG")
	private Long denominatorFlag;
	
	@JsonInclude
	@Column(name="DENOMINATOR_EXCLUSION_FLAG")
	private Long denominatorExclusionFlag;
	
	@JsonInclude
	@Column(name="DENOMINATOR_EXCEPTION_FLAG")
	private Long denominatorExceptionFlag;
	
	@JsonInclude
	@Column(name="NUMERATOR_FLAG")
	private Long numeratorFlag;
	
	@JsonInclude
	@Column(name="NUMERATOR_EXCLUSION_FLAG")
	private Long numeratorExclusionFlag;
	
	@JsonInclude
	@Column(name="FINAL_FLAG")
	private Long finalFlag;
	
	@JsonInclude
	@Column(name="PLD_COLUMN_NAME")
	private String pldColumnName;
	
	@JsonInclude
	@Column(name="TYPE_OF_EXCLUSION")
	private String typeOfExclusion;

	public Long getHdePldMeasXWalkSeq() {
		return hdePldMeasXWalkSeq;
	}

	public void setHdePldMeasXWalkSeq(Long hdePldMeasXWalkSeq) {
		this.hdePldMeasXWalkSeq = hdePldMeasXWalkSeq;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getMeasureId() {
		return measureId;
	}

	public void setMeasureId(String measureId) {
		this.measureId = measureId;
	}

	public String getStratificationId() {
		return stratificationId;
	}

	public void setStratificationId(String stratificationId) {
		this.stratificationId = stratificationId;
	}

	public Long getDenominatorFlag() {
		return denominatorFlag;
	}

	public void setDenominatorFlag(Long denominatorFlag) {
		this.denominatorFlag = denominatorFlag;
	}

	public Long getDenominatorExclusionFlag() {
		return denominatorExclusionFlag;
	}

	public void setDenominatorExclusionFlag(Long denominatorExclusionFlag) {
		this.denominatorExclusionFlag = denominatorExclusionFlag;
	}

	public Long getDenominatorExceptionFlag() {
		return denominatorExceptionFlag;
	}

	public void setDenominatorExceptionFlag(Long denominatorExceptionFlag) {
		this.denominatorExceptionFlag = denominatorExceptionFlag;
	}

	public Long getNumeratorFlag() {
		return numeratorFlag;
	}

	public void setNumeratorFlag(Long numeratorFlag) {
		this.numeratorFlag = numeratorFlag;
	}

	public Long getNumeratorExclusionFlag() {
		return numeratorExclusionFlag;
	}

	public void setNumeratorExclusionFlag(Long numeratorExclusionFlag) {
		this.numeratorExclusionFlag = numeratorExclusionFlag;
	}

	public Long getFinalFlag() {
		return finalFlag;
	}

	public void setFinalFlag(Long finalFlag) {
		this.finalFlag = finalFlag;
	}

	public String getPldColumnName() {
		return pldColumnName;
	}

	public void setPldColumnName(String pldColumnName) {
		this.pldColumnName = pldColumnName;
	}

	public String getTypeOfExclusion() {
		return typeOfExclusion;
	}

	public void setTypeOfExclusion(String typeOfExclusion) {
		this.typeOfExclusion = typeOfExclusion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}