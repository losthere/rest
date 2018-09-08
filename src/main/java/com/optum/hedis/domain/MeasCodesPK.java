package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the OHM_MEAS_CODES database table.
 **/

@Embeddable
public class MeasCodesPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="MEASUREMENT_YR")
	private long measurementYr;

	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="CODE")
	private String code;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}