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
@Table(name = "HDE_VENDOR_EVENT_XWALK")
public class VendorEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "Hde_Vendor_Event_Xwalk")
	@SequenceGenerator(name = "Hde_Vendor_Event_Xwalk", sequenceName = "HDE_VENDOR_EVENT_XWALK_SEQ")
	@Column(name = "HDE_VENDOR_EVENT_XWALK_SEQ")
	private long hdeVendorEventXwalkSeq;

	@Column(name = "VENDOR_KEY")
	private Long vendorKey;

	@Column(name = "MEASURE_NAME")
	private String measureName;
	
	@Column(name = "SUBMEASURE")
	private String subMeasure;
	
	@Column(name = "EVENT_DESCR")
	private String eventDescr;
	
	@Column(name = "METRIC_CODE")
	private String metricCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	public long getHdeVendorEventXwalkSeq() {
		return hdeVendorEventXwalkSeq;
	}

	public void setHdeVendorEventXwalkSeq(long hdeVendorEventXwalkSeq) {
		this.hdeVendorEventXwalkSeq = hdeVendorEventXwalkSeq;
	}

	public Long getVendorKey() {
		return vendorKey;
	}

	public void setVendorKey(Long vendorKey) {
		this.vendorKey = vendorKey;
	}

	public String getMeasureName() {
		return measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getSubMeasure() {
		return subMeasure;
	}

	public void setSubMeasure(String subMeasure) {
		this.subMeasure = subMeasure;
	}

	public String getEventDescr() {
		return eventDescr;
	}

	public void setEventDescr(String eventDescr) {
		this.eventDescr = eventDescr;
	}

	public String getMetricCode() {
		return metricCode;
	}

	public void setMetricCode(String metricCode) {
		this.metricCode = metricCode;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
