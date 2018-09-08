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
@Table(name="NUMERATOR")
public class OhrNumerator implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ohrNumeratorSeq")
	@SequenceGenerator(name = "ohrNumeratorSeq", sequenceName = "OHR_NUMERATOR_SEQ")
	@Column(name="NUMERATOR_ID")
	private Long numeratorId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="NUMERATOR_CODE")
	private String numeratorCode;
	
	@Column(name="NUMERATOR_NAME")
	private String numeratorName;
	
	@Column(name="SCORE_TYPE")
	private String scoreType;
	
	@Column(name="BENEFITID")
	private String benefitid;
	
	@Column(name="EXTIDENT")
	private String extident;
	
	@Column(name="HASCOMORBID")
	private String hasComorbid;
	
	@Column(name="ISACTIVE")
	private Long isActive;
	
	@Column(name="ISPARENT")
	private Long isParent;
	
	@Column(name="ISSHOWN")
	private Long isShown;
	
	@Column(name="PARENTID")
	private String parentId;
	
	@Column(name="SHORTDESCR")
	private String shortDescr;
	
	@Column(name="STRATAGEID")
	private String stratageId;
	
	@Column(name="STRATID")
	private String stratId;
	
	@Column(name="DISPLAY_SORT_BY")
	private Long displaySortBy;
	
	@Column(name="MIN_VALUE")
	private Long minValue;
	
	@Column(name="MAX_VALUE")
	private Long maxValue;
	
	@Column(name="RATE_TYPE")
	private String rateType;
	
	@Column(name="RATE_DATA_TYPE")
	private String rateDataType;
	
	@Column(name="TREND_GRAPH_IND")
	private Character trendGraphInd;
	
	@Column(name="GOAL_ENTRY_IND")
	private Character goalEntryInd;
	
	@Column(name="PREV_COMPARE_IND")
	private Character prevCompareInd;
	
	@Column(name="NUMERATOR_DETAIL")
	private String numeratorDetail;
	
	@Column(name="ISMARKETPLACE")
	private Long isMarketPlace;
	
	@Column(name="CREAT_USER")
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name="CREAT_TMSTMP")
	private Date creatTmstmp;
	
	@Column(name="UPDT_USER")
	private String updtUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDT_TMSTMP")
	private Date updtTmstmp;
	
	@Column(name="NUM_CODE")
	private String numCode;
	
	@Column(name="ISCOMMERCIAL")
	private Long isCommercial;
	
	@Column(name="ISMEDICARE")
	private Long isMedicare;
	
	@Column(name="ISMEDICAID")
	private Long isMedicaid;
	
	@Column(name="ISSNP")
	private Long isSnp;
	
	@Column(name="P4P_MEASURE_CODE")
	private String p4pMeasureCode;
	
	
	public Long getNumeratorId() {
		return numeratorId;
	}


	public void setNumeratorId(Long numeratorId) {
		this.numeratorId = numeratorId;
	}


	public Long getMeasureId() {
		return measureId;
	}


	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}


	public String getNumeratorCode() {
		return numeratorCode;
	}


	public void setNumeratorCode(String numeratorCode) {
		this.numeratorCode = numeratorCode;
	}


	public String getNumeratorName() {
		return numeratorName;
	}


	public void setNumeratorName(String numeratorName) {
		this.numeratorName = numeratorName;
	}


	public String getScoreType() {
		return scoreType;
	}


	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}


	public String getBenefitid() {
		return benefitid;
	}


	public void setBenefitid(String benefitid) {
		this.benefitid = benefitid;
	}


	public String getExtident() {
		return extident;
	}


	public void setExtident(String extident) {
		this.extident = extident;
	}


	public String getHasComorbid() {
		return hasComorbid;
	}


	public void setHasComorbid(String hasComorbid) {
		this.hasComorbid = hasComorbid;
	}


	public Long getIsActive() {
		return isActive;
	}


	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}


	public Long getIsParent() {
		return isParent;
	}


	public void setIsParent(Long isParent) {
		this.isParent = isParent;
	}


	public Long getIsShown() {
		return isShown;
	}


	public void setIsShown(Long isShown) {
		this.isShown = isShown;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public String getShortDescr() {
		return shortDescr;
	}


	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}


	public String getStratageId() {
		return stratageId;
	}


	public void setStratageId(String stratageId) {
		this.stratageId = stratageId;
	}


	public String getStratId() {
		return stratId;
	}


	public void setStratId(String stratId) {
		this.stratId = stratId;
	}


	public Long getDisplaySortBy() {
		return displaySortBy;
	}


	public void setDisplaySortBy(Long displaySortBy) {
		this.displaySortBy = displaySortBy;
	}


	public Long getMinValue() {
		return minValue;
	}


	public void setMinValue(Long minValue) {
		this.minValue = minValue;
	}


	public Long getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}


	public String getRateType() {
		return rateType;
	}


	public void setRateType(String rateType) {
		this.rateType = rateType;
	}


	public String getRateDataType() {
		return rateDataType;
	}


	public void setRateDataType(String rateDataType) {
		this.rateDataType = rateDataType;
	}


	public Character getTrendGraphInd() {
		return trendGraphInd;
	}


	public void setTrendGraphInd(Character trendGraphInd) {
		this.trendGraphInd = trendGraphInd;
	}


	public Character getGoalEntryInd() {
		return goalEntryInd;
	}


	public void setGoalEntryInd(Character goalEntryInd) {
		this.goalEntryInd = goalEntryInd;
	}


	public Character getPrevCompareInd() {
		return prevCompareInd;
	}


	public void setPrevCompareInd(Character prevCompareInd) {
		this.prevCompareInd = prevCompareInd;
	}


	public String getNumeratorDetail() {
		return numeratorDetail;
	}


	public void setNumeratorDetail(String numeratorDetail) {
		this.numeratorDetail = numeratorDetail;
	}


	public Long getIsMarketPlace() {
		return isMarketPlace;
	}


	public void setIsMarketPlace(Long isMarketPlace) {
		this.isMarketPlace = isMarketPlace;
	}





	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public Date getCreatTmstmp() {
		return creatTmstmp;
	}


	public void setCreatTmstmp(Date creatTmstmp) {
		this.creatTmstmp = creatTmstmp;
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


	public String getNumCode() {
		return numCode;
	}


	public void setNumCode(String numCode) {
		this.numCode = numCode;
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


	public String getP4pMeasureCode() {
		return p4pMeasureCode;
	}


	public void setP4pMeasureCode(String p4pMeasureCode) {
		this.p4pMeasureCode = p4pMeasureCode;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}