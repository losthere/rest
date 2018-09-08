package com.optum.hedis.domain;

import java.io.Serializable;
import java.sql.Clob;
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
@Table(name="RUN_RESULTS_DEF")
public class RunResultsDef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "runResultsDefSeq")
	@SequenceGenerator(name = "runResultsDefSeq", sequenceName = "RUN_RESULTS_DEF_SEQ")
	@Column(name="RUN_RESULTS_DEF_ID")
	private Long runResultsDefId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="NUMERATOR_ID")
	private Long numeratorId;
	
	@Column(name="HASHYBRID")
	private Long hasHybrid;
	
	@Column(name="USEINOUTLIERREPORT")
	private String useInOutlierReport;
	
	@Column(name="ADMIN_RATE")
	private Clob adminRate;
	
	@Column(name="ADMIN_NUM_HITS")
	private String adminNumHits;
	
	@Column(name="ADMIN_DENOM_HITS")
	private String adminDenomHits;
	
	@Column(name="HYBRID_RATE")
	private String hybridRate;
	
	@Column(name="HYBRID_NUM_HITS")
	private String hybridNumHits;
	
	@Column(name="HYBRID_DENOM_HITS")
	private String hybridDenomHits;
	
	@Column(name="HYBRID_ADMIN_HITS")
	private String hybridAdminHits;
	
	@Column(name="HYBRID_MED_HITS")
	private String hybridMedHits;
	
	@Column(name="HYB_ADMIN_NUMERATOR")
	private String hybAdminNumerator;
	
	@Column(name="HYB_ADMIN_RATE")
	private String hybAdminRate;
	
	@Column(name="RATE_DATA_TYPE")
	private String rateDataType;
	
	@Column(name="PRODUCT_LINE")
	private String productLine;
	
	@Column(name="RATE_TYPE")
	private String rateType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREAT_TMSTMP")
	private Date creatTmstmp;
	
	@Column(name="CREAT_USER")
	private String creatUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDT_TMSTMP")
	private Date updtTmstmp;
	
	@Column(name="UPDT_USER")
	private String updtUser;
	
	@Column(name="SUPPLMNTL_NUMERATOR")
	private String supplmntlNumerator;
	
	@Column(name="EXCLUSION_CNT")
	private String exclusionCnt;
	
	@Column(name="REQUIRED_ADMIN_EXCLUSION_CNT")
	private String requiredAdminExclusionCnt;
	
	@Column(name="REQUIRED_HYBRID_EXCLUSION_CNT")
	private String requiredHybridExclusionCnt;
	
	@Column(name="OPTIONAL_ADMIN_EXCLUSION_CNT")
	private String optionalAdminExclusionCnt;
	
	@Column(name="OPTIONAL_HYBRID_EXCLUSION_CNT")
	private String optionalHybridExclusionCnt;
	
	@Column(name="MEASURE_YEAR")
	private String measureYear;
	
	public Long getRunResultsDefId() {
		return runResultsDefId;
	}

	public void setRunResultsDefId(Long runResultsDefId) {
		this.runResultsDefId = runResultsDefId;
	}

	public Long getMeasureId() {
		return measureId;
	}



	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}



	public Long getNumeratorId() {
		return numeratorId;
	}



	public void setNumeratorId(Long numeratorId) {
		this.numeratorId = numeratorId;
	}



	public Long getHasHybrid() {
		return hasHybrid;
	}



	public void setHasHybrid(Long hasHybrid) {
		this.hasHybrid = hasHybrid;
	}



	public String getUseInOutlierReport() {
		return useInOutlierReport;
	}



	public void setUseInOutlierReport(String useInOutlierReport) {
		this.useInOutlierReport = useInOutlierReport;
	}

	public String getAdminRate() {
		return adminRate.toString().substring(1,7);
	}

	public void setAdminRate(Clob adminRate) {
		this.adminRate = adminRate;
	}

	public String getAdminNumHits() {
		return adminNumHits;
	}

	public void setAdminNumHits(String adminNumHits) {
		this.adminNumHits = adminNumHits;
	}



	public String getAdminDenomHits() {
		return adminDenomHits;
	}



	public void setAdminDenomHits(String adminDenomHits) {
		this.adminDenomHits = adminDenomHits;
	}



	public String getHybridRate() {
		return hybridRate;
	}



	public void setHybridRate(String hybridRate) {
		this.hybridRate = hybridRate;
	}



	public String getHybridNumHits() {
		return hybridNumHits;
	}



	public void setHybridNumHits(String hybridNumHits) {
		this.hybridNumHits = hybridNumHits;
	}



	public String getHybridDenomHits() {
		return hybridDenomHits;
	}



	public void setHybridDenomHits(String hybridDenomHits) {
		this.hybridDenomHits = hybridDenomHits;
	}



	public String getHybridAdminHits() {
		return hybridAdminHits;
	}



	public void setHybridAdminHits(String hybridAdminHits) {
		this.hybridAdminHits = hybridAdminHits;
	}



	public String getHybridMedHits() {
		return hybridMedHits;
	}



	public void setHybridMedHits(String hybridMedHits) {
		this.hybridMedHits = hybridMedHits;
	}



	public String getHybAdminNumerator() {
		return hybAdminNumerator;
	}



	public void setHybAdminNumerator(String hybAdminNumerator) {
		this.hybAdminNumerator = hybAdminNumerator;
	}



	public String getHybAdminRate() {
		return hybAdminRate;
	}



	public void setHybAdminRate(String hybAdminRate) {
		this.hybAdminRate = hybAdminRate;
	}



	public String getRateDataType() {
		return rateDataType;
	}



	public void setRateDataType(String rateDataType) {
		this.rateDataType = rateDataType;
	}



	public String getProductLine() {
		return productLine;
	}



	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}



	public String getRateType() {
		return rateType;
	}



	public void setRateType(String rateType) {
		this.rateType = rateType;
	}



	public Date getCreateTmstmp() {
		return creatTmstmp;
	}



	public void setCreateTmstmp(Date createTmstmp) {
		this.creatTmstmp = createTmstmp;
	}



	public String getCreateUser() {
		return creatUser;
	}



	public void setCreateUser(String createUser) {
		this.creatUser = createUser;
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



	public String getSupplmntlNumerator() {
		return supplmntlNumerator;
	}



	public void setSupplmntlNumerator(String supplmntlNumerator) {
		this.supplmntlNumerator = supplmntlNumerator;
	}



	public String getExclusionCnt() {
		return exclusionCnt;
	}



	public void setExclusionCnt(String exclusionCnt) {
		this.exclusionCnt = exclusionCnt;
	}



	public String getRequiredAdminExclusionCnt() {
		return requiredAdminExclusionCnt;
	}



	public void setRequiredAdminExclusionCnt(String requiredAdminExclusionCnt) {
		this.requiredAdminExclusionCnt = requiredAdminExclusionCnt;
	}



	public String getRequiredHybridExclusionCnt() {
		return requiredHybridExclusionCnt;
	}



	public void setRequiredHybridExclusionCnt(String requiredHybridExclusionCnt) {
		this.requiredHybridExclusionCnt = requiredHybridExclusionCnt;
	}



	public String getOptionalAdminExclusionCnt() {
		return optionalAdminExclusionCnt;
	}



	public void setOptionalAdminExclusionCnt(String optionalAdminExclusionCnt) {
		this.optionalAdminExclusionCnt = optionalAdminExclusionCnt;
	}



	public String getOptionalHybridExclusionCnt() {
		return optionalHybridExclusionCnt;
	}



	public void setOptionalHybridExclusionCnt(String optionalHybridExclusionCnt) {
		this.optionalHybridExclusionCnt = optionalHybridExclusionCnt;
	}



	public String getMeasureYear() {
		return measureYear;
	}



	public void setMeasureYear(String measureYear) {
		this.measureYear = measureYear;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

