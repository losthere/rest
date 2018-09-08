package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the HDE_MEAS_AUDIT_CW database table.
 **/

@Embeddable
public class MeasAuditPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="MEASUREMENT_YR")
	private long measurementYr;

	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@Column(name="METRIC_CODE")
	private String metricCode;

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

	public String getMetricCode() {
		return metricCode;
	}

	public void setMetricCode(String metricCode) {
		this.metricCode = metricCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}