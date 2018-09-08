package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.Idss;

@Repository
public interface IdssRepository extends JpaRepository<Idss, Long>,JpaSpecificationExecutor<Idss> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_IDSS_TABLE = "insert into NCQA_IDSS_XWALK (NCQA_IDSS_XWALK_SEQ, MEASUREMENT_YR, MEASURE_NAME, ELEMENT_NAME, RPT_ELEMENT_NAME, REPORT_TYPE, MEASURE_DESCR, STRATIFICATION_ID, STRATIFICAITON_DESC, SOURCE_TYPE, ELEMENT_TYPE, ELEMENT_NAME_RISK, ELEMENT_NAME_AGE, ELEMENT_NAME_GENDER, IS_ACTIVE, IS_COMMERCIAL, IS_MEDICARE, IS_MEDICAID, IS_SNP, ELEMENT_DESCR, RPT_DECIMAL, DATA_PAYER_ID, AUDIT_HEADER, IS_REPORTABLE, CREATE_DT, CREATED_BY, IS_MARKETPLACE, AGG_ELEMENT_TYPE, SUMMARY_GROUP, SUMMARY_ELEMENT_TYPE, AGE, GENDER, RISK) select NCQA_IDSS_XWALK_SEQ.NEXTVAL, :toYear, MEASURE_NAME, ELEMENT_NAME, RPT_ELEMENT_NAME, REPORT_TYPE, MEASURE_DESCR, STRATIFICATION_ID, STRATIFICAITON_DESC, SOURCE_TYPE, ELEMENT_TYPE, ELEMENT_NAME_RISK, ELEMENT_NAME_AGE, ELEMENT_NAME_GENDER, IS_ACTIVE, IS_COMMERCIAL, IS_MEDICARE, IS_MEDICAID, IS_SNP, ELEMENT_DESCR, RPT_DECIMAL, DATA_PAYER_ID, AUDIT_HEADER, IS_REPORTABLE, CREATE_DT, CREATED_BY, IS_MARKETPLACE, AGG_ELEMENT_TYPE, SUMMARY_GROUP, SUMMARY_ELEMENT_TYPE, AGE, GENDER, RISK from NCQA_IDSS_XWALK where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_IDSS_TABLE = "delete Idss where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_IDSS_TABLE = "select ncqaIdssXWalkSeq, measurementYr, measureName, elementName, rptElementName, reportType, measureDesc, stratificationId, stratificationDesc, sourceType, elementType, elementNameRisk, elementNameAge, elementNameGender, isActive, isCommercial, isMedicare, isMedicaid, isSnp, elementDescr, rptDecimal, dataPayerId, auditHeader, isReportable, createDt, createdBy, isMarketPlace, aggElementType, summaryGroup, summaryElementType, age, gender, risk  from Idss order by ncqaIdssXWalkSeq";
	String GET_IDSS_FULL_TABLE = "select ncqaIdssXWalkSeq, measurementYr, measureName, elementName, rptElementName, reportType, measureDesc, stratificationId, stratificationDesc, sourceType, elementType, elementNameRisk, elementNameAge, elementNameGender, isActive, isCommercial, isMedicare, isMedicaid, isSnp, elementDescr, rptDecimal, dataPayerId, auditHeader, isReportable, createDt, createdBy, isMarketPlace, aggElementType, summaryGroup, summaryElementType, age, gender, risk  from Idss order by ncqaIdssXWalkSeq";
	String GET_IDSS_TABLE_FOR_EXPORT = "select measurementYr, measureName, elementName, rptElementName, reportType, measureDesc, stratificationId, stratificationDesc, sourceType, elementType, elementNameRisk, elementNameAge, elementNameGender, isActive, isCommercial, isMedicare, isMedicaid, isSnp, elementDescr, rptDecimal, dataPayerId, auditHeader, isReportable, createDt, createdBy, isMarketPlace, aggElementType, summaryGroup, summaryElementType, age, gender, risk  from Idss order by ncqaIdssXWalkSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_IDSS_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_IDSS_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_IDSS_TABLE)
	List<Object[]> getIdssTable();
	
	@Query(value = GET_IDSS_FULL_TABLE)
	List<Object[]> getIdssFullTable();
	
	@Query(value = GET_IDSS_TABLE_FOR_EXPORT)
	List<Object[]> getIdssTableForExport();
}