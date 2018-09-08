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
@Table(name = "NCQA_MEASURES_TO_VALUESETS")
public class MeasureValueSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Ncqa_Measures_To_Valuesets_Seq")
	@SequenceGenerator(name = "Ncqa_Measures_To_Valuesets_Seq", sequenceName = "NCQA_MEASURES_TO_VALUESETS_SEQ")
	@Column(name = "NCQA_MEASURES_TO_VALUESETS_SEQ")
	private long ncqaMeasuresToValuesetsSeq;

	@Column(name = "MEASUREMENT_YR")
	private Long measurementYr;

	@Column(name = "MEASURE_NAME")
	private String measureName;

	@Column(name = "MEAS_DESC")
	private String measDesc;
	
	@Column(name = "VALUESET_NAME")
	private String valuesetName;
	
	@Column(name = "VALUESET_OID")
	private String valuesetOid;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "STRATIFICATION_ID")
	private String stratificationId;

	public long getNcqaMeasuresToValuesetsSeq() {
		return ncqaMeasuresToValuesetsSeq;
	}

	public void setNcqaMeasuresToValuesetsSeq(long ncqaMeasuresToValuesetsSeq) {
		this.ncqaMeasuresToValuesetsSeq = ncqaMeasuresToValuesetsSeq;
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

	public String getMeasDesc() {
		return measDesc;
	}

	public void setMeasDesc(String measDesc) {
		this.measDesc = measDesc;
	}

	public String getValuesetName() {
		return valuesetName;
	}

	public void setValuesetName(String valuesetName) {
		this.valuesetName = valuesetName;
	}

	public String getValuesetOid() {
		return valuesetOid;
	}

	public void setValuesetOid(String valuesetOid) {
		this.valuesetOid = valuesetOid;
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

	public String getStratificationId() {
		return stratificationId;
	}

	public void setStratificationId(String stratificationId) {
		this.stratificationId = stratificationId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
