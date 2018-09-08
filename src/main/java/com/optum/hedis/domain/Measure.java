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
@Table(name="NCQA_MEASURES")
public class Measure implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(generator = "Ncqa_Measures_Seq")
	@SequenceGenerator(name = "Ncqa_Measures_Seq", sequenceName = "NCQA_MEASURES_SEQ")
	@JsonInclude
	@Column(name="NCQA_MEASURES_SEQ")
	private long ncqaMeasuresSeq;
	
	@JsonInclude
	@Column(name="MEASUREMENT_YR")
	private long measurementYr;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@JsonInclude
	@Column(name="MEASURE_DESCR")
	private String measureDescr;
	
	@JsonInclude
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@JsonInclude
	@Column(name="HAS_HYBRID")
	private Long hasHybrid;
	
	@JsonInclude
	@Column(name="IS_COMMERCIAL")
	@JsonIgnore
	private Long isCommercial;
	
	@JsonInclude
	@Column(name="IS_MEDICAID")
	private Long isMedicaid;
	
	@JsonInclude
	@Column(name="IS_MEDICARE")
	private Long isMedicare;
	
	@JsonInclude
	@Column(name="IS_SNP")
	private Long isSnp;
	
	@JsonInclude
	@Column(name="NUMERATOR_COUNT")
	private Long numeratorCount;
	
	@JsonInclude
	@Column(name="RUN_TYPE")
	private String runType;
	
	@JsonInclude
	@Column(name="STORE_TYPE")
	private String storeType;
	
	@JsonInclude
	@Column(name="IS_STARS")
	private Long isStars;
	
	@JsonInclude
	@Column(name="DOMAIN_ID")
	private Long domainId;
	
	@JsonInclude
	@Column(name="SUB_DOMAIN_ID")
	private Long subDomainId;
	
	@JsonInclude
	@Column(name="SOURCE_TYPE")
	private String sourceType;
	
	@Temporal(TemporalType.DATE)
	@JsonInclude
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@JsonInclude
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@JsonInclude
	@Column(name="IS_REPORTABLE")
	private Long isReportable;
	
	@JsonInclude
	@Column(name="IS_MARKETPLACE")
	private Long isMarketPlace;
	
	@JsonInclude
	@Column(name="HYB_MEDICAID")
	private Long hybMedicaid;
	
	@JsonInclude
	@Column(name="HYB_MEDICARE")
	private Long hybMedicare;
	
	@JsonInclude
	@Column(name="HYB_MARKETPLACE")
	private Long hybMarketPlace;
	
	@JsonInclude
	@Column(name="HYB_SNP")
	private Long hybSnp;
	
	@JsonInclude
	@Column(name="HYB_COMMERCIAL")
	private Long hybCommercial;

	public long getNcqaMeasuresSeq() {
		return ncqaMeasuresSeq;
	}

	public void setNcqaMeasuresSeq(long ncqaMeasuresSeq) {
		this.ncqaMeasuresSeq = ncqaMeasuresSeq;
	}

	public long getMeasurementYr() {
		return measurementYr;
	}

	public void setMeasurementYr(long measurementYr) {
		this.measurementYr = measurementYr;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getMeasureDescr() {
		return measureDescr;
	}

	public void setMeasureDescr(String measureDescr) {
		this.measureDescr = measureDescr;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Long getHasHybrid() {
		return hasHybrid;
	}

	public void setHasHybrid(Long hasHybrid) {
		this.hasHybrid = hasHybrid;
	}

	public Long getIsCommercial() {
		return isCommercial;
	}

	public void setIsCommercial(Long isCommercial) {
		this.isCommercial = isCommercial;
	}

	public Long getIsMedicaid() {
		return isMedicaid;
	}

	public void setIsMedicaid(Long isMedicaid) {
		this.isMedicaid = isMedicaid;
	}

	public Long getIsMedicare() {
		return isMedicare;
	}

	public void setIsMedicare(Long isMedicare) {
		this.isMedicare = isMedicare;
	}

	public Long getIsSnp() {
		return isSnp;
	}

	public void setIsSnp(Long isSnp) {
		this.isSnp = isSnp;
	}

	public Long getNumeratorCount() {
		return numeratorCount;
	}

	public void setNumeratorCount(Long numeratorCount) {
		this.numeratorCount = numeratorCount;
	}

	public String getRunType() {
		return runType;
	}

	public void setRunType(String runType) {
		this.runType = runType;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public Long getIsStars() {
		return isStars;
	}

	public void setIsStars(Long isStars) {
		this.isStars = isStars;
	}

	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public Long getSubDomainId() {
		return subDomainId;
	}

	public void setSubDomainId(Long subDomainId) {
		this.subDomainId = subDomainId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
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

	public Long getIsReportable() {
		return isReportable;
	}

	public void setIsReportable(Long isReportable) {
		this.isReportable = isReportable;
	}

	public Long getIsMarketPlace() {
		return isMarketPlace;
	}

	public void setIsMarketPlace(Long isMarketPlace) {
		this.isMarketPlace = isMarketPlace;
	}

	public Long getHybMedicaid() {
		return hybMedicaid;
	}

	public void setHybMedicaid(Long hybMedicaid) {
		this.hybMedicaid = hybMedicaid;
	}

	public Long getHybMedicare() {
		return hybMedicare;
	}

	public void setHybMedicare(Long hybMedicare) {
		this.hybMedicare = hybMedicare;
	}

	public Long getHybMarketPlace() {
		return hybMarketPlace;
	}

	public void setHybMarketPlace(Long hybMarketPlace) {
		this.hybMarketPlace = hybMarketPlace;
	}

	public Long getHybSnp() {
		return hybSnp;
	}

	public void setHybSnp(Long hybSnp) {
		this.hybSnp = hybSnp;
	}

	public Long getHybCommercial() {
		return hybCommercial;
	}

	public void setHybCommercial(Long hybCommercial) {
		this.hybCommercial = hybCommercial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}