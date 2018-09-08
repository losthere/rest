package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.DenominatorEadMetricDef;


public interface DenominatorEadMetricDefRepository extends JpaRepository<DenominatorEadMetricDef, Long>,JpaSpecificationExecutor<DenominatorEadMetricDef> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE = "insert into DENOMINATOR_EAD_METRIC_DEF (DENOMINATOR_EAD_METRIC_DEF_ID, MEASURE_ID, METRIC_CODE, METRIC_NAME,NUMERATOR_CODE,CREAT_TMSTMP, CREAT_USER,MEASURE_YEAR,MEASURE_SET) select DENOMINATOR_EAD_METRIC_DEF_ID, MEASURE_ID, METRIC_CODE, METRIC_NAME,NUMERATOR_CODE,CREAT_TMSTMP, CREAT_USER,:toYear,MEASURE_SET from DENOMINATOR_EAD_METRIC_DEF where MEASURE_YEAR = :fromYear";
	String DELETE_MEASURE_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE = "delete DenominatorEadMetricDef where measureId = :measureId and measureYear = :selectedYearToDeleteMeasure";
	String GET_DENOMINATOR_EAD_METRIC_DEF_FULL_TABLE = "select '',denominatorEadMetricDefId,measureId,metricCode,metricName,numeratorCode,creatTmstmp,createUser,measureYear,measureSet from DenominatorEadMetricDef order by denominatorEadMetricDefId";
	String GET_DENOMINATOR_EAD_METRIC_DEF_TABLE = "select '',m.measure_code,d.metric_Code,d.metric_Name,d.numerator_Code,d.measure_Year,d.measure_Set from DENOMINATOR_EAD_METRIC_DEF d left join measure_master m on d.measure_id = m.measure_id";
	String GET_DENOMINATOR_EAD_METRIC_DEF_TABLE_FOR_EXPORT = "select * from DENOMINATOR_EAD_METRIC_DEF";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear); 
	
	@Query(value = DELETE_MEASURE_IN_DENOMINATOR_EAD_METRIC_DEF_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_DENOMINATOR_EAD_METRIC_DEF_TABLE,nativeQuery = true)
	List<Object[]> getdenominatorEadMetricDefTable();
	
	@Query(value = GET_DENOMINATOR_EAD_METRIC_DEF_FULL_TABLE)
	List<Object[]> getdenominatorEadMetricDefFullTable();
	
	@Query(value = GET_DENOMINATOR_EAD_METRIC_DEF_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getdenominatorEadMetricDefTableForExport();
}
