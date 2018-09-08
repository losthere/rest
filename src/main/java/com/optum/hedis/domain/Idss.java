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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="NCQA_IDSS_XWALK")
public class Idss implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Ncqa_Idss_XWalk_Seq")
	@SequenceGenerator(name = "Ncqa_Idss_XWalk_Seq", sequenceName = "NCQA_IDSS_XWALK_SEQ")
	@JsonInclude
	@Column(name="NCQA_IDSS_XWALK_SEQ")
	private Long ncqaIdssXWalkSeq;
	
	@JsonInclude
	@Column(name="MEASUREMENT_YR")
	private Long measurementYr;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@JsonInclude
	@Column(name="ELEMENT_NAME")
	private String elementName;
	
	@JsonInclude
	@Column(name="RPT_ELEMENT_NAME")
	private String rptElementName;
	
	@JsonInclude
	@Column(name="REPORT_TYPE")
	private String reportType;
	
	@JsonInclude
	@Column(name="MEASURE_DESCR")
	private String measureDesc;
	
	@JsonInclude
	@Column(name="STRATIFICATION_ID")
	private String stratificationId;
	
	@JsonInclude
	@Column(name="STRATIFICAITON_DESC")
	private String stratificationDesc;
	
	@JsonInclude
	@Column(name="SOURCE_TYPE")
	private String sourceType;
	
	@JsonInclude
	@Column(name="ELEMENT_TYPE")
	private String elementType;
	
	@JsonInclude
	@Column(name="ELEMENT_NAME_RISK")
	private String elementNameRisk;
	
	@JsonInclude
	@Column(name="ELEMENT_NAME_AGE")
	private String elementNameAge;
	
	@JsonInclude
	@Column(name="ELEMENT_NAME_GENDER")
	private String elementNameGender;
	
	@JsonInclude
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@JsonInclude
	@Column(name="IS_COMMERCIAL")
	private Long isCommercial;
	
	@JsonInclude
	@Column(name="IS_MEDICARE")
	private Long isMedicare;
	
	@JsonInclude
	@Column(name="IS_MEDICAID")
	private Long isMedicaid;
	
	@JsonInclude
	@Column(name="IS_SNP")
	private Long isSnp;
	
	@JsonInclude
	@Column(name="ELEMENT_DESCR")
	private String elementDescr;
	
	@JsonInclude
	@Column(name="RPT_DECIMAL")
	private String rptDecimal;
	
	@JsonInclude
	@Column(name="DATA_PAYER_ID")
	private String dataPayerId;
	
	@JsonInclude
	@Column(name="AUDIT_HEADER")
	private String auditHeader;
	
	@JsonInclude
	@Column(name="IS_REPORTABLE")
	private Long isReportable;
	
	@Temporal(TemporalType.DATE)
	@JsonInclude
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@JsonInclude
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@JsonInclude
	@Column(name="IS_MARKETPLACE")
	private Long isMarketPlace;
	
	@JsonInclude
	@Column(name="AGG_ELEMENT_TYPE")
	private String aggElementType;
	
	@JsonInclude
	@Column(name="SUMMARY_GROUP")
	private String summaryGroup;
	
	@JsonInclude
	@Column(name="SUMMARY_ELEMENT_TYPE")
	private String summaryElementType;
	
	@JsonInclude
	@Column(name="AGE")
	private String age;
	
	@JsonInclude
	@Column(name="GENDER")
	private String gender;
	
	@JsonInclude
	@Column(name="RISK")
	private String risk;

	public Long getNcqaIdssXWalkSeq() {
		return ncqaIdssXWalkSeq;
	}

	public void setNcqaIdssXWalkSeq(Long ncqaIdssXWalkSeq) {
		this.ncqaIdssXWalkSeq = ncqaIdssXWalkSeq;
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

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getRptElementName() {
		return rptElementName;
	}

	public void setRptElementName(String rptElementName) {
		this.rptElementName = rptElementName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getMeasureDesc() {
		return measureDesc;
	}

	public void setMeasureDesc(String measureDesc) {
		this.measureDesc = measureDesc;
	}

	public String getStratificationId() {
		return stratificationId;
	}

	public void setStratificationId(String stratificationId) {
		this.stratificationId = stratificationId;
	}

	public String getStratificationDesc() {
		return stratificationDesc;
	}

	public void setStratificationDesc(String stratificationDesc) {
		this.stratificationDesc = stratificationDesc;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getElementNameRisk() {
		return elementNameRisk;
	}

	public void setElementNameRisk(String elementNameRisk) {
		this.elementNameRisk = elementNameRisk;
	}

	public String getElementNameAge() {
		return elementNameAge;
	}

	public void setElementNameAge(String elementNameAge) {
		this.elementNameAge = elementNameAge;
	}

	public String getElementNameGender() {
		return elementNameGender;
	}

	public void setElementNameGender(String elementNameGender) {
		this.elementNameGender = elementNameGender;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Long getIsCommercial() {
		return isCommercial;
	}

	public void setIsCommercial(Long isCommercial) {
		this.isCommercial = isCommercial;
	}

	public Long getIsMedicare() {
		return isMedicare;
	}

	public void setIsMedicare(Long isMedicare) {
		this.isMedicare = isMedicare;
	}

	public Long getIsMedicaid() {
		return isMedicaid;
	}

	public void setIsMedicaid(Long isMedicaid) {
		this.isMedicaid = isMedicaid;
	}

	public Long getIsSnp() {
		return isSnp;
	}

	public void setIsSnp(Long isSnp) {
		this.isSnp = isSnp;
	}

	public String getElementDescr() {
		return elementDescr;
	}

	public void setElementDescr(String elementDescr) {
		this.elementDescr = elementDescr;
	}

	public String getRptDecimal() {
		return rptDecimal;
	}

	public void setRptDecimal(String rptDecimal) {
		this.rptDecimal = rptDecimal;
	}

	public String getDataPayerId() {
		return dataPayerId;
	}

	public void setDataPayerId(String dataPayerId) {
		this.dataPayerId = dataPayerId;
	}

	public String getAuditHeader() {
		return auditHeader;
	}

	public void setAuditHeader(String auditHeader) {
		this.auditHeader = auditHeader;
	}

	public Long getIsReportable() {
		return isReportable;
	}

	public void setIsReportable(Long isReportable) {
		this.isReportable = isReportable;
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

	public Long getIsMarketPlace() {
		return isMarketPlace;
	}

	public void setIsMarketPlace(Long isMarketPlace) {
		this.isMarketPlace = isMarketPlace;
	}

	public String getAggElementType() {
		return aggElementType;
	}

	public void setAggElementType(String aggElementType) {
		this.aggElementType = aggElementType;
	}

	public String getSummaryGroup() {
		return summaryGroup;
	}

	public void setSummaryGroup(String summaryGroup) {
		this.summaryGroup = summaryGroup;
	}

	public String getSummaryElementType() {
		return summaryElementType;
	}

	public void setSummaryElementType(String summaryElementType) {
		this.summaryElementType = summaryElementType;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
