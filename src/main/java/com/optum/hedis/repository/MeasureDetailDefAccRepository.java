package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.DenominatorEadMetricDef;
import com.optum.hedis.domain.MeasureDetailDefAcc;

public interface MeasureDetailDefAccRepository extends JpaRepository<MeasureDetailDefAcc, Long>,JpaSpecificationExecutor<MeasureDetailDefAcc> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASUERE_DETAIL_DEF_ACC_TABLE = "insert into MEASURE_DETAIL_DEF_ACC (MEASURE_DETAIL_DEF_ID, MEASURE_ID, METRIC_CODE, METRIC_NAME, PROCESSING_RULE, TBL, FLD, NUMERATOR_CODE, METRIC_ORDER, CREAT_TMSTMP, CREAT_USER, UPDT_TMSTMP, UPDT_USER, MEASURE_YEAR, MEASURE_SET_NAME) select MEASURE_DETAIL_DEF_ID, MEASURE_ID, METRIC_CODE, METRIC_NAME, PROCESSING_RULE, TBL, FLD, NUMERATOR_CODE, METRIC_ORDER, CREAT_TMSTMP, CREAT_USER, UPDT_TMSTMP, UPDT_USER, :toYear, MEASURE_SET_NAME from MEASURE_DETAIL_DEF_ACC where MEASURE_YEAR = :fromYear";
	String DELETE_MEASURE_DETAIL_DEF_ACC_TABLE = "delete MeasureDetailDefAcc where measureId = :measureId and measureYear = :selectedYearToDeleteMeasure";
	String GET_MEASURE_DETAIL_DEF_ACC_TABLE = "select '',m.measure_code, d.metric_Code, d.metric_Name, d.processing_Rule, d.tbl,d.numerator_Code, d.metric_Order,d.measure_Year, d.MEASURE_SET_NAME from MEASURE_DETAIL_DEF_ACC d join measure_master m on  d.measure_id = m.measure_id";
	String GET_MEASURE_DETAIL_DEF_ACC_FULL_TABLE = "select '',measureDetailDefId, measureId, metricCode, metricName, processingRule, tbl, fld, numeratorCode, metricOrder, creatTmstmp, createUser, updtTmstmp, updtUser, measureYear, measureSetName from MeasureDetailDefAcc order by measureDetailDefId";
    String GET_MEASURE_DETAIL_DEF_ACC_TABLE_FOR_EXPORT = "select * from MEASURE_DETAIL_DEF_ACC";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASUERE_DETAIL_DEF_ACC_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);
	
	@Query(value = DELETE_MEASURE_DETAIL_DEF_ACC_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_MEASURE_DETAIL_DEF_ACC_TABLE,nativeQuery = true)
	List<Object[]> getmeasureDetailDefAccTable();
	
	@Query(value = GET_MEASURE_DETAIL_DEF_ACC_FULL_TABLE)
	List<Object[]> getmeasureDetailDefAccFullTable();
	
	@Query(value = GET_MEASURE_DETAIL_DEF_ACC_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getMeasureDetailDefAccTableForExport();
}
