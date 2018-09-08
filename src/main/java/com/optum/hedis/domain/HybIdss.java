package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="NCQA_HYB_IDSS_XWALK")
public class HybIdss implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="HYB_IDSS_CW_KEY")
	private Long hybIdssCwKey;
	
	@Column(name="MEASUREMENT_YR")
	private Long measurementYr;
	
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@Column(name="NUMERATOR_ID")
	private String numeratorId;
	
	@Column(name="STRATIFICATION_ID")
	private String stratificationId;
	
	@Column(name="PRODUCT_LINE")
	private String productLine;
	
	@Column(name="IDSS_ELEMENT")
	private String idssElement;
	
	@Column(name="HYB_ELEMENT_TYPE")
	private String hybElementType;
	
	@Column(name="ELEMENT_TYPE")
	private String elementType;
	
	@Column(name="AGG_LEVEL")
	private String aggLevel;
	
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="NO_OF_NUMERATORS")
	private Long noOfNumerators;

	public Long getHybIdssCwKey() {
		return hybIdssCwKey;
	}

	public void setHybIdssCwKey(Long hybIdssCwKey) {
		this.hybIdssCwKey = hybIdssCwKey;
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

	public String getNumeratorId() {
		return numeratorId;
	}

	public void setNumeratorId(String numeratorId) {
		this.numeratorId = numeratorId;
	}

	public String getStratificationId() {
		return stratificationId;
	}

	public void setStratificationId(String stratificationId) {
		this.stratificationId = stratificationId;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getIdssElement() {
		return idssElement;
	}

	public void setIdssElement(String idssElement) {
		this.idssElement = idssElement;
	}

	public String getHybElementType() {
		return hybElementType;
	}

	public void setHybElementType(String hybElementType) {
		this.hybElementType = hybElementType;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getAggLevel() {
		return aggLevel;
	}

	public void setAggLevel(String aggLevel) {
		this.aggLevel = aggLevel;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
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

	public Long getNoOfNumerators() {
		return noOfNumerators;
	}

	public void setNoOfNumerators(Long noOfNumerators) {
		this.noOfNumerators = noOfNumerators;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
