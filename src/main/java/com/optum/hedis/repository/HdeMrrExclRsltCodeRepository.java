package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.HdeMrrExclRsltCode;

public interface HdeMrrExclRsltCodeRepository extends JpaRepository<HdeMrrExclRsltCode, Long>,JpaSpecificationExecutor<HdeMrrExclRsltCode> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into HDE_MRR_EXCL_RSLT_CODE (HDE_MRR_EXCL_RSLT_CODE_SEQ, MEAS_YR, MEASURE_NAME, STRATIFICATION_ID, CODE, IS_RESULT, IS_EXCLSION, IS_VALID_DATA_ERR, IS_MRR_OPT_EXCL, IS_MRR_REQ_EXCL, IS_CBP_FALSE_POSITIVE) select HDE_MRR_EXCL_RSLT_CODE_SEQ.NEXTVAL, :toYear, MEASURE_NAME, STRATIFICATION_ID, CODE, IS_RESULT, IS_EXCLSION, IS_VALID_DATA_ERR, IS_MRR_OPT_EXCL, IS_MRR_REQ_EXCL, IS_CBP_FALSE_POSITIVE from HDE_MRR_EXCL_RSLT_CODE where MEAS_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete HdeMrrExclRsltCode where measureName = :measureName and measYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select hdeMrrExclRsltCodeSeq, measYr, measureName, stratificationId, code, isResult, isExclsion, isValidDataErr, isMrrOptExcl, isMrrReqExcl, isCbpFalsePositive from HdeMrrExclRsltCode order by hdeMrrExclRsltCodeSeq";
	String GET_FULL_TABLE = "select hdeMrrExclRsltCodeSeq, measYr, measureName, stratificationId, code, isResult, isExclsion, isValidDataErr, isMrrOptExcl, isMrrReqExcl, isCbpFalsePositive from HdeMrrExclRsltCode order by hdeMrrExclRsltCodeSeq";
	String GET_TABLE_FOR_EXPORT = "select measYr, measureName, stratificationId, code, isResult, isExclsion, isValidDataErr, isMrrOptExcl, isMrrReqExcl, isCbpFalsePositive from HdeMrrExclRsltCode order by hdeMrrExclRsltCodeSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getHdeMrrExclRsltCodeTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getHdeMrrExclRsltCodeFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getHdeMrrExclRsltCodeTableForExport();
}

