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
@Table(name="MEASURE_DETAIL_DEF_ACC")
public class MeasureDetailDefAcc implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "measureDetailDefAccSeq")
	@SequenceGenerator(name = "measureDetailDefAccSeq", sequenceName = "MEASURE_DETAIL_DEF_ACC_SEQ")
	@Column(name="MEASURE_DETAIL_DEF_ID")
	private Long measureDetailDefId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="METRIC_CODE")
	private String metricCode;
	
	@Column(name="METRIC_NAME")
	private String metricName;
	
	@Column(name="PROCESSING_RULE")
	private String processingRule;
	
	@Column(name="TBL")
	private String tbl;
	
	@Column(name="FLD")
	private String fld;
	
	@Column(name="NUMERATOR_CODE")
	private String numeratorCode;
	
	@Column(name="METRIC_ORDER")
	private Long metricOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREAT_TMSTMP")
	private Date creatTmstmp;
	
	@Column(name="CREAT_USER")
	private String createUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDT_TMSTMP")
	private Date updtTmstmp;
	
	@Column(name="UPDT_USER")
	private String updtUser;
	
	@Column(name="MEASURE_YEAR")
	private String measureYear;
	
	@Column(name="MEASURE_SET_NAME")
	private String measureSetName;
	
	
	
	public Long getMeasureDetailDefId() {
		return measureDetailDefId;
	}



	public void setMeasureDetailDefId(Long measureDetailDefId) {
		this.measureDetailDefId = measureDetailDefId;
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



	public String getProcessingRule() {
		return processingRule;
	}



	public void setProcessingRule(String processingRule) {
		this.processingRule = processingRule;
	}



	public String getTbl() {
		return tbl;
	}



	public void setTbl(String tbl) {
		this.tbl = tbl;
	}



	public String getFld() {
		return fld;
	}



	public void setFld(String fld) {
		this.fld = fld;
	}



	public String getNumeratorCode() {
		return numeratorCode;
	}



	public void setNumeratorCode(String numeratorCode) {
		this.numeratorCode = numeratorCode;
	}



	public Long getMetricOrder() {
		return metricOrder;
	}



	public void setMetricOrder(Long metricOrder) {
		this.metricOrder = metricOrder;
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



	public Date getUpdtTmstmp() {
		return updtTmstmp;
	}



	public void setUpdtTmstmp(Date updtTmstmp) {
		this.updtTmstmp = updtTmstmp;
	}



	public String getUpdtUser() {
		return updtUser;
	}



	public void setUpdtUser(String updtUser) {
		this.updtUser = updtUser;
	}



	public String getMeasureYear() {
		return measureYear;
	}



	public void setMeasureYear(String measureYear) {
		this.measureYear = measureYear;
	}



	public String getMeasureSetName() {
		return measureSetName;
	}



	public void setMeasureSetName(String measureSetName) {
		this.measureSetName = measureSetName;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
