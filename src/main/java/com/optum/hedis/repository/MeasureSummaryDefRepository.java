package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.MeasureSummaryDef;

public interface MeasureSummaryDefRepository extends JpaRepository<MeasureSummaryDef, Long>,JpaSpecificationExecutor<MeasureSummaryDef> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_SUMMARY_DEF_TABLE = "insert into MEASURE_SUMMARY_DEF (MEASURE_SUMMARY_DEF_ID, MEASURE_ID, REPORT_TYPE, PRODUCT_LINE, AGG_TYPE, GRID_NUM, ROW1_HEADER, ROW2_HEADER, ROW3_HEADER, ROW1, ROW2, ROW3, ROW1_SORT, ROW2_SORT, ROW3_SORT, COLUMN1, COLUMN2, COLUMN3, COLUMN1_SORT, COLUMN2_SORT, COLUMN3_SORT, ELEMENT_ID, DISPLAY_TYPE, CODE, CREAT_TMSTMP, CREAT_USER, UPDT_TMSTMP, UPDT_USER, MEASURE_YEAR) select MEASURE_SUMMARY_DEF_ID, MEASURE_ID, REPORT_TYPE, PRODUCT_LINE, AGG_TYPE, GRID_NUM, ROW1_HEADER, ROW2_HEADER, ROW3_HEADER, ROW1, ROW2, ROW3, ROW1_SORT, ROW2_SORT, ROW3_SORT, COLUMN1, COLUMN2, COLUMN3, COLUMN1_SORT, COLUMN2_SORT, COLUMN3_SORT, ELEMENT_ID, DISPLAY_TYPE, CODE, CREAT_TMSTMP, CREAT_USER, UPDT_TMSTMP, UPDT_USER,:toYear from MEASURE_SUMMARY_DEF where MEASURE_YEAR =:fromYear";
	String DELETE_MEASURE_IN_MEASURE_SUMMARY_DEF_TABLE = "delete MeasureSummaryDef where measureId = :measureId and measureYear = :selectedYearToDeleteMeasure";
	String GET_MEASURE_SUMMARY_DEF_FULL_TABLE = "select '',measureSummaryDefId,measureId,reportType,productLine,aggType,gridNum,row1Header,row2Header,row3Header,row1,row2,row3,row1Sort,row2Sort,row3Sort,column1,column2,column3,column1Sort,column2Sort,column3Sort,elementId,displayType,code,creatTmstmp,createUser,updtTmstmp,updtUser,measureYear from MeasureSummaryDef order by measureSummaryDefId";
	String GET_MEASURE_SUMMARY_DEF_TABLE = "select '',m.MEASURE_CODE,d.measure_Id,d.report_Type,d.product_Line,d.agg_Type,d.grid_Num,d.row1_Header,d.row2_Header,d.row3_Header,d.row1,d.row2,d.row3,d.row1_Sort,d.row2_Sort,d.row3_Sort,d.column2,d.column3,d.column1_Sort,d.column2_Sort,d.column3_Sort,d.element_Id,d.display_Type,d.code,d.measure_Year from Measure_Summary_Def d join measure_master m on d.measure_id = m.measure_id";
	String GET_MEASURE_SUMMARY_DEF_TABLE_FOR_EXPORT = "select * from MEASURE_SUMMARY_DEF order by MEASURE_SUMMARY_DEF_ID";
	String GET_PRODUCT_LINE = "select PRODUCT_LINE_CODE from PRODUCT_LINE";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_SUMMARY_DEF_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);
	
	@Query(value = DELETE_MEASURE_IN_MEASURE_SUMMARY_DEF_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_MEASURE_SUMMARY_DEF_FULL_TABLE)
	List<Object[]> getmeasureSummaryDefFullTable();
	
	@Query(value = GET_PRODUCT_LINE, nativeQuery = true)
	List<String> getProductLineDetails();
	
	@Query(value = GET_MEASURE_SUMMARY_DEF_TABLE,nativeQuery = true)
	List<Object[]> getmeasureSummaryDefTable();
	
	@Query(value = GET_MEASURE_SUMMARY_DEF_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getMeasureSummaryDefTableForExport();
}
