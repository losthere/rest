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
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="DENOMINATOR_EAD_METRIC_DEF")
public class DenominatorEadMetricDef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "denominatorEadMetricDefSeq")
	@SequenceGenerator(name = "denominatorEadMetricDefSeq", sequenceName = "DENOMINATOR_EAD_METRIC_DEF_SEQ")
	@Column(name="DENOMINATOR_EAD_METRIC_DEF_ID")
	private Long denominatorEadMetricDefId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="METRIC_CODE")
	private String metricCode;
	
	@Column(name="METRIC_NAME")
	private String metricName;
	
	@Column(name="NUMERATOR_CODE")
	private String numeratorCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREAT_TMSTMP")
	private Date creatTmstmp;
	
	@Column(name="CREAT_USER")
	private String createUser;
	
	@Column(name="MEASURE_YEAR")
	private String measureYear;
	
	@Column(name="MEASURE_SET")
	private String measureSet;

	public Long getDenominatorEadMetricDefId() {
		return denominatorEadMetricDefId;
	}

	public void setDenominatorEadMetricDefId(Long denominatorEadMetricDefId) {
		this.denominatorEadMetricDefId = denominatorEadMetricDefId;
	}

	public Long getMeasureId() {
		return measureId;
	}

	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}

	public String getMetricCode() {
		return metricCode;
	}

	public void setMetricCode(String metricCode) {
		this.metricCode = metricCode;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public String getNumeratorCode() {
		return numeratorCode;
	}

	public void setNumeratorCode(String numeratorCode) {
		this.numeratorCode = numeratorCode;
	}

	public Date getCreatTmstmp() {
		return creatTmstmp;
	}

	public void setCreatTmstmp(Date creatTmstmp) {
		this.creatTmstmp = creatTmstmp;
	}



	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getMeasureYear() {
		return measureYear;
	}

	public void setMeasureYear(String measureYear) {
		this.measureYear = measureYear;
	}

	public String getMeasureSet() {
		return measureSet;
	}

	public void setMeasureSet(String measureSet) {
		this.measureSet = measureSet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
