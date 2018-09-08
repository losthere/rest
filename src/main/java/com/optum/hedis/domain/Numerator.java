package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.optum.hedis.domain.NumeratorPK;

@Entity
@Table(name="NCQA_NUMERATORS")
public class Numerator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private NumeratorPK id;
	
	@JsonInclude
	@Column(name="MEASURE_NAME")
	private String measureName;

	@JsonInclude
	@Column(name="RPT_DESCR")
	private String rptDescr;

	@JsonInclude
	@Column(name="DESCR")
	private String descr;
	
	@JsonInclude
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@Temporal(TemporalType.DATE)
	@JsonInclude
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@JsonInclude
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@JsonInclude
	@Column(name="IS_REPORTABLE")
	private Long isReportable;
	
	@JsonInclude
	@Column(name="OHM_DESCR")
	private String ohmDescr;
}
