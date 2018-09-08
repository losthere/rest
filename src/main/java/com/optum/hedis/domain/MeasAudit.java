package com.optum.hedis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HDE_MEAS_AUDIT_CW")
public class MeasAudit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MeasAuditPK id;
	
	@Column(name="OBJ_VALUE_TYPE")
	private String objValueType;
	
	@Column(name="IS_CHASE")
	private Long isChase;
	
	@Column(name="IS_CS_REPORTABLE")
	private Long isCsReportable;
	
	@Column(name="IS_ACTIVE")
	private Long isActive;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT")
	private Date createDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT")
	private Date updateDt;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="IS_PH_REPORTABLE")
	private Long isPhReportable;
}