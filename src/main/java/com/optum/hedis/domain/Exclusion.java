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
@Table(name="HDE_EXCLUSIONS_XWALK")
public class Exclusion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "XWalk_Hde_Exclusions_XWalk_Seq")
	@SequenceGenerator(name = "XWalk_Hde_Exclusions_XWalk_Seq", sequenceName = "HDE_EXCLUSIONS_XWALK_SEQ")
	@Column(name="HDE_EXCLUSIONS_XWALK_SEQ")
	@JsonInclude
	private Long hdeExclusionsXWalkSeq;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@JsonInclude
	@Column(name="NUMERATOR_ID")
	private String numeratorId;
	
	@JsonInclude
	@Column(name="EXCLUSION_TYPE")
	private String exclusionType;
	
	public Long getHdeExclusionsXWalkSeq() {
		return hdeExclusionsXWalkSeq;
	}

	public void setHdeExclusionsXWalkSeq(Long hdeExclusionsXWalkSeq) {
		this.hdeExclusionsXWalkSeq = hdeExclusionsXWalkSeq;
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

	public String getExclusionType() {
		return exclusionType;
	}

	public void setExclusionType(String exclusionType) {
		this.exclusionType = exclusionType;
	}

}
