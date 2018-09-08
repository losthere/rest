package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DASH_MEASURE_SUMMARY_DEF")
public class DashMeasureSummaryDef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "dashMeasureSummaryDefSeq")
	@SequenceGenerator(name = "dashMeasureSummaryDefSeq", sequenceName = "DASH_MEASURE_SUMMARY_DEF_SEQ")
	@Column(name="DASH_MEASURE_SUMMARY_DEF_ID")
	private Long dashMeasureSummaryDefId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="MEASURE_TYPE")
	private String measureType;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="CATEGORY_TREND")
	private Character categoryTrend;
	
	@Column(name="CATEGORY_VALUE")
	private String categoryValue;
	
	@Column(name="CALC_TYPE")
	private String calcType;
	
	@Column(name="SERIES_NAME")
	private String seriesName;
	
	@Column(name="DISPLAY_LABEL")
	private String displayLabel;
	
	@Column(name="SORT_ORDER")
	private Long sortOrder;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="NUMERATOR_ID")
	private Long numeratorId;
	
	@Column(name="DISPLAY_TYPE")
	private String displayType;
	
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
	
	@Column(name="MEASURE_YEAR")
	private String measureYear;
	
/*	@OneToOne()
	@JoinColumn(name = "measureId")
	private MeasureMaster measureMaster;*/
	
	
	public Long getDashMeasureSummaryDefId() {
		return dashMeasureSummaryDefId;
	}



	public void setDashMeasureSummaryDefId(Long dashMeasureSummaryDefId) {
		this.dashMeasureSummaryDefId = dashMeasureSummaryDefId;
	}



	public Long getMeasureId() {
		return measureId;
	}



	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}



	public String getMeasureType() {
		return measureType;
	}



	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}





	public Character getCategoryTrend() {
		return categoryTrend;
	}



	public void setCategoryTrend(Character categoryTrend) {
		this.categoryTrend = categoryTrend;
	}



	public String getCategoryValue() {
		return categoryValue;
	}



	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}



	public String getCalcType() {
		return calcType;
	}



	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}



	public String getSeriesName() {
		return seriesName;
	}



	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}



	public String getDisplayLabel() {
		return displayLabel;
	}



	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}



	public Long getSortOrder() {
		return sortOrder;
	}



	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public Long getNumeratorId() {
		return numeratorId;
	}



	public void setNumeratorId(Long numeratorId) {
		this.numeratorId = numeratorId;
	}



	public String getDisplayType() {
		return displayType;
	}



	public void setDisplayType(String displayType) {
		this.displayType = displayType;
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



	public String getMeasureYear() {
		return measureYear;
	}



	public void setMeasureYear(String measureYear) {
		this.measureYear = measureYear;
	}
	


/*	public MeasureMaster getMeasureMaster() {
		return measureMaster;
	}



	public void setMeasureMaster(MeasureMaster measureMaster) {
		this.measureMaster = measureMaster;
	}*/



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

