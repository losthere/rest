package com.optum.hedis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HDE_MRR_EXCL_RSLT_CODE")
public class HdeMrrExclRsltCode implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(generator = "Hde_Mrr_Excl_Rslt_Code_Seq")
	@SequenceGenerator(name = "Hde_Mrr_Excl_Rslt_Code_Seq", sequenceName = "HDE_MRR_EXCL_RSLT_CODE_SEQ")
	@Column(name="HDE_MRR_EXCL_RSLT_CODE_SEQ")
	private long hdeMrrExclRsltCodeSeq;
	
	@Column(name="MEAS_YR")
	private long measYr;
	
	@Column(name="MEASURE_NAME")
	private String measureName;
	
	@Column(name="STRATIFICATION_ID")
	private String stratificationId;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="IS_RESULT")
	private Long isResult;
	
	@Column(name="IS_EXCLSION")
	private Long isExclsion;
	
	@Column(name="IS_VALID_DATA_ERR")
	private Long isValidDataErr;
	
	@Column(name="IS_MRR_OPT_EXCL")
	private Long isMrrOptExcl;
	
	@Column(name="IS_MRR_REQ_EXCL")
	private Long isMrrReqExcl;
	
	@Column(name="IS_CBP_FALSE_POSITIVE")
	private Long isCbpFalsePositive;

	public long getHdeMrrExclRsltCodeSeq() {
		return hdeMrrExclRsltCodeSeq;
	}

	public void setHdeMrrExclRsltCodeSeq(long hdeMrrExclRsltCodeSeq) {
		this.hdeMrrExclRsltCodeSeq = hdeMrrExclRsltCodeSeq;
	}

	public long getMeasYr() {
		return measYr;
	}

	public void setMeasYr(long measYr) {
		this.measYr = measYr;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getIsResult() {
		return isResult;
	}

	public void setIsResult(Long isResult) {
		this.isResult = isResult;
	}

	public Long getIsExclsion() {
		return isExclsion;
	}

	public void setIsExclsion(Long isExclsion) {
		this.isExclsion = isExclsion;
	}

	public Long getIsValidDataErr() {
		return isValidDataErr;
	}

	public void setIsValidDataErr(Long isValidDataErr) {
		this.isValidDataErr = isValidDataErr;
	}

	public Long getIsMrrOptExcl() {
		return isMrrOptExcl;
	}

	public void setIsMrrOptExcl(Long isMrrOptExcl) {
		this.isMrrOptExcl = isMrrOptExcl;
	}

	public Long getIsMrrReqExcl() {
		return isMrrReqExcl;
	}

	public void setIsMrrReqExcl(Long isMrrReqExcl) {
		this.isMrrReqExcl = isMrrReqExcl;
	}

	public Long getIsCbpFalsePositive() {
		return isCbpFalsePositive;
	}

	public void setIsCbpFalsePositive(Long isCbpFalsePositive) {
		this.isCbpFalsePositive = isCbpFalsePositive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

