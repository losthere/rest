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
@Table(name = "HDE_VENDOR_NUM_XWALK")
public class VendorNum implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Hde_Vendor_Num_Xwalk")
	@SequenceGenerator(name = "Hde_Vendor_Num_Xwalk", sequenceName = "HDE_VENDOR_NUM_XWALK_SEQ")
	@Column(name = "HDE_VENDOR_NUM_XWALK_SEQ")
	private long hdeVendorNumXwalkSeq;

	@Column(name = "VENDOR_KEY")
	private Long vendorKey;

	@Column(name = "VENDOR_ID")
	private String vendorId;
	
	@Column(name = "MEASURE_NAME")
	private String measureName;
	
	@Column(name = "STRATIFICATION_ID")
	private String stratificationId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "VENDOR_SUB_MEASURE")
	private String vendorSubMeasure;

	public long getHdeVendorNumXwalkSeq() {
		return hdeVendorNumXwalkSeq;
	}

	public void setHdeVendorNumXwalkSeq(long hdeVendorNumXwalkSeq) {
		this.hdeVendorNumXwalkSeq = hdeVendorNumXwalkSeq;
	}

	public Long getVendorKey() {
		return vendorKey;
	}

	public void setVendorKey(Long vendorKey) {
		this.vendorKey = vendorKey;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getStratificationId() {
		return stratificationId;
	}

	public void setStratificationId(String stratificationId) {
		this.stratificationId = stratificationId;
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

	public String getVendorSubMeasure() {
		return vendorSubMeasure;
	}

	public void setVendorSubMeasure(String vendorSubMeasure) {
		this.vendorSubMeasure = vendorSubMeasure;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
