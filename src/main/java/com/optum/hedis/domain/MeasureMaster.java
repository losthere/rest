package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MEASURE_MASTER")
public class MeasureMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "measureMasterSeq")
	@SequenceGenerator(name = "measureMasterSeq", sequenceName = "MEASURE_MASTER_SEQ")
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="MEASURE_CODE")
	private String measureCode;
	
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@Column(name="MEASURE_YEAR")
	private String measureYear;
	
	@Column(name="DOMAINID")
	private String domainId;
	
	@Column(name="HASHYBRID")
	private Long hasHybrid;
	
	@Column(name="ISACTIVE")
	private Long isActive;
	
	@Column(name="ISCOMMERCIAL")
	private Long isCommercial;
	
	@Column(name="ISMEDICAID")
	private Long isMedicaid;
	
	@Column(name="ISMEDICARE")
	private Long isMedicare;
	
	@Column(name="ISMARKETPLACE")
	private Long isMarketPlace;
	
	@Column(name="ISSNP")
	private Long isSnp;
	
	@Column(name="NUMCNT")
	private Long numCnt;
	
	@Column(name="RUNTYPE")
	private String runType;
	
	@Column(name="STORETYPE")
	private String storeType;
	
	@Column(name="SUBDOMAINID")
	private String subDomainId;
	
	@Column(name="ISSTARS")
	private Long isStars;
	
	@Column(name="ISNONHEDIS")
	private Long isNonhedis;
	
	@Column(name="SOURCE_TYPE")
	private String sourceType;
	
	@Column(name="MANUAL_ENTRY_IND")
	private Long manualEntryInd;
	
	@Column(name="ISPLD")
	private Long isPld;
	
	@Column(name="CREAT_USER")
	private String createUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREAT_TMSTMP")
	private Date createTmstmp;
	
	@Column(name="UPDT_USER")
	private String updtUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDT_TMSTMP")
	private Date updtTmstmp;
	
	@Column(name="P4P_MEASURE_CODE")
	private String p4pMeasureCode;
	
/*    @OneToOne(fetch=FetchType.LAZY, mappedBy="measureMaster")
    private DashMeasureSummaryDef dashMeasureSummaryDef;*/
	
	public Long getMeasureId() {
		return measureId;
	}

	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}

	public String getMeasureCode() {
		return measureCode;
	}

	public void setMeasureCode(String measureCode) {
		this.measureCode = measureCode;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getMeasureYear() {
		return measureYear;
	}

	public void setMeasureYear(String measureYear) {
		this.measureYear = measureYear;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public Long getHasHybrid() {
		return hasHybrid;
	}

	public void setHasHybrid(Long hasHybrid) {
		this.hasHybrid = hasHybrid;
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

	public Long getIsMarketPlace() {
		return isMarketPlace;
	}

	public void setIsMarketPlace(Long isMarketPlace) {
		this.isMarketPlace = isMarketPlace;
	}

	public Long getIsSnp() {
		return isSnp;
	}

	public void setIsSnp(Long isSnp) {
		this.isSnp = isSnp;
	}

	public Long getNumCnt() {
		return numCnt;
	}

	public void setNumCnt(Long numCnt) {
		this.numCnt = numCnt;
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

	public String getSubDomainId() {
		return subDomainId;
	}

	public void setSubDomainId(String subDomainId) {
		this.subDomainId = subDomainId;
	}

	public Long getIsStars() {
		return isStars;
	}

	public void setIsStars(Long isStars) {
		this.isStars = isStars;
	}

	public Long getIsNonhedis() {
		return isNonhedis;
	}

	public void setIsNonhedis(Long isNonhedis) {
		this.isNonhedis = isNonhedis;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public Long getManualEntryInd() {
		return manualEntryInd;
	}

	public void setManualEntryInd(Long manualEntryInd) {
		this.manualEntryInd = manualEntryInd;
	}

	public Long getIsPld() {
		return isPld;
	}

	public void setIsPld(Long isPld) {
		this.isPld = isPld;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTmstmp() {
		return createTmstmp;
	}

	public void setCreateTmstmp(Date createTmstmp) {
		this.createTmstmp = createTmstmp;
	}

	public String getUpdtUser() {
		return updtUser;
	}

	public void setUpdtUser(String updtUser) {
		this.updtUser = updtUser;
	}

	public Date getUpdtTmstmp() {
		return updtTmstmp;
	}

	public void setUpdtTmstmp(Date updtTmstmp) {
		this.updtTmstmp = updtTmstmp;
	}

	public String getP4pMeasureCode() {
		return p4pMeasureCode;
	}

	public void setP4pMeasureCode(String p4pMeasureCode) {
		this.p4pMeasureCode = p4pMeasureCode;
	}
	
/*
	public DashMeasureSummaryDef getDashMeasureSummaryDef() {
		return dashMeasureSummaryDef;
	}

	public void setDashMeasureSummaryDef(DashMeasureSummaryDef dashMeasureSummaryDef) {
		this.dashMeasureSummaryDef = dashMeasureSummaryDef;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

