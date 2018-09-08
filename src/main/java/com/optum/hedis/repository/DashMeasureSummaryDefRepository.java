package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.DashMeasureSummaryDef;
import com.optum.hedis.domain.DenominatorEadMetricDef;

public interface DashMeasureSummaryDefRepository extends JpaRepository<DashMeasureSummaryDef, Long>,JpaSpecificationExecutor<DashMeasureSummaryDef> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_DASH_MEASURE_SUMMARY_DEF_TABLE = "insert into DASH_MEASURE_SUMMARY_DEF (DASH_MEASURE_SUMMARY_DEF_ID,MEASURE_ID,MEASURE_TYPE,CATEGORY,CATEGORY_TREND,CATEGORY_VALUE,CALC_TYPE,SERIES_NAME,DISPLAY_LABEL,SORT_ORDER,VALUE,NUMERATOR_ID,DISPLAY_TYPE,CREAT_USER,CREAT_TMSTMP,UPDT_USER,UPDT_TMSTMP,MEASURE_YEAR) select DASH_MEASURE_SUMMARY_DEF_ID,MEASURE_ID,MEASURE_TYPE,CATEGORY,CATEGORY_TREND,CATEGORY_VALUE,CALC_TYPE,SERIES_NAME,DISPLAY_LABEL,SORT_ORDER,VALUE,NUMERATOR_ID,DISPLAY_TYPE,CREAT_USER,CREAT_TMSTMP,UPDT_USER,UPDT_TMSTMP,:toYear from DASH_MEASURE_SUMMARY_DEF where MEASURE_YEAR = :fromYear";
	String DELETE_MEASURE_IN_DASH_MEASURE_SUMMARY_DEF_TABLE = "delete DASH_MEASURE_SUMMARY_DEF where MEASURE_ID = :measureId and MEASURE_YEAR = :selectedYearToDeleteMeasure";
	String GET_DASH_MEASURE_SUMMARY_DEF_TABLE = "select '',m.measure_Code,d.measure_Type,d.series_Name,d.display_Label,d.sort_Order,d.value,n.numerator_code,d.display_Type,d.measure_Year from Dash_Measure_Summary_Def d left join MEASURE_MASTER m on  d.measure_Id = m.measure_Id left join numerator n on d.NUMERATOR_ID=n.NUMERATOR_ID";
	String GET_DASH_MEASURE_SUMMARY_DEF_FULL_TABLE = "select '',dashMeasureSummaryDefId,measureId,measureType,category,categoryTrend,categoryValue,calcType,seriesName,displayLabel,sortOrder,value,numeratorId,displayType,createUser,creatTmstmp,updtUser,updtTmstmp,measureYear from DashMeasureSummaryDef";
	String GET_DASH_MEASURE_SUMMARY_DEF_TABLE_FOR_EXPORT = "select * from DASH_MEASURE_SUMMARY_DEF order by DASH_MEASURE_SUMMARY_DEF_ID";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_DASH_MEASURE_SUMMARY_DEF_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);
	
	@Query(value = DELETE_MEASURE_IN_DASH_MEASURE_SUMMARY_DEF_TABLE, nativeQuery = true)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_DASH_MEASURE_SUMMARY_DEF_TABLE, nativeQuery = true)
	List<Object[]> getdashMeasureSummaryDefTable();
	
	@Query(value = GET_DASH_MEASURE_SUMMARY_DEF_FULL_TABLE)
	List<Object[]> getdashMeasureSummaryDefFullTable();
	
	@Query(value = GET_DASH_MEASURE_SUMMARY_DEF_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getDashMeasureSummaryDefTableForExport();
}
