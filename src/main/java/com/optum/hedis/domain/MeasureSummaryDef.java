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
@Table(name="MEASURE_SUMMARY_DEF")
public class MeasureSummaryDef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "measureSummaryDefSeq")
	@SequenceGenerator(name = "measureSummaryDefSeq", sequenceName = "MEASURE_SUMMARY_DEF_SEQ")
	@Column(name="MEASURE_SUMMARY_DEF_ID")
	private Long measureSummaryDefId;
	
	@Column(name="MEASURE_ID")
	private Long measureId;
	
	@Column(name="REPORT_TYPE")
	private Character reportType;
	
	@Column(name="PRODUCT_LINE")
	private String productLine;
	
	@Column(name="AGG_TYPE")
	private String aggType;
	
	@Column(name="GRID_NUM")
	private Long gridNum;
	
	@Column(name="ROW1_HEADER")
	private String row1Header;
	
	@Column(name="ROW2_HEADER")
	private String row2Header;
	
	@Column(name="ROW3_HEADER")
	private String row3Header;
	
	@Column(name="ROW1")
	private String row1;
	
	@Column(name="ROW2")
	private String row2;
	
	@Column(name="ROW3")
	private String row3;
	
	@Column(name="ROW1_SORT")
	private Long row1Sort;
	
	@Column(name="ROW2_SORT")
	private Long row2Sort;
	
	@Column(name="ROW3_SORT")
	private Long row3Sort;
	
	@Column(name="COLUMN1")
	private String column1;
	
	@Column(name="COLUMN2")
	private String column2;
	
	@Column(name="COLUMN3")
	private String column3;
	
	@Column(name="COLUMN1_SORT")
	private Long column1Sort;
	
	@Column(name="COLUMN2_SORT")
	private Long column2Sort;
	
	@Column(name="COLUMN3_SORT")
	private Long column3Sort;
	
	@Column(name="ELEMENT_ID")
	private String elementId;
	
	@Column(name="DISPLAY_TYPE")
	private String displayType;
	
	@Column(name="CODE")
	private String code;
	
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
	
	public Long getMeasureSummaryDefId() {
		return measureSummaryDefId;
	}

	public void setMeasureSummaryDefId(Long measureSummaryDefId) {
		this.measureSummaryDefId = measureSummaryDefId;
	}

	public Long getMeasureId() {
		return measureId;
	}

	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}


	public Character getReportType() {
		return reportType;
	}

	public void setReportType(Character reportType) {
		this.reportType = reportType;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getRow1() {
		return row1;
	}

	public void setRow1(String row1) {
		this.row1 = row1;
	}

	public String getRow2() {
		return row2;
	}

	public void setRow2(String row2) {
		this.row2 = row2;
	}

	public String getRow3() {
		return row3;
	}

	public void setRow3(String row3) {
		this.row3 = row3;
	}

	public Long getRow1Sort() {
		return row1Sort;
	}

	public void setRow1Sort(Long row1Sort) {
		this.row1Sort = row1Sort;
	}

	public Long getRow2Sort() {
		return row2Sort;
	}

	public void setRow2Sort(Long row2Sort) {
		this.row2Sort = row2Sort;
	}

	public Long getRow3Sort() {
		return row3Sort;
	}

	public void setRow3Sort(Long row3Sort) {
		this.row3Sort = row3Sort;
	}

	public Long getColumn2Sort() {
		return column2Sort;
	}

	public void setColumn2Sort(Long column2Sort) {
		this.column2Sort = column2Sort;
	}

	public Long getColumn3Sort() {
		return column3Sort;
	}

	public void setColumn3Sort(Long column3Sort) {
		this.column3Sort = column3Sort;
	}

	public String getAggType() {
		return aggType;
	}

	public void setAggType(String aggType) {
		this.aggType = aggType;
	}

	public Long getGridNum() {
		return gridNum;
	}

	public void setGridNum(Long gridNum) {
		this.gridNum = gridNum;
	}

	public String getRow1Header() {
		return row1Header;
	}

	public void setRow1Header(String row1Header) {
		this.row1Header = row1Header;
	}

	public String getRow2Header() {
		return row2Header;
	}

	public void setRow2Header(String row2Header) {
		this.row2Header = row2Header;
	}

	public String getRow3Header() {
		return row3Header;
	}

	public void setRow3Header(String row3Header) {
		this.row3Header = row3Header;
	}

	
	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public Long getColumn1Sort() {
		return column1Sort;
	}

	public void setColumn1Sort(Long column1Sort) {
		this.column1Sort = column1Sort;
	}

	

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

