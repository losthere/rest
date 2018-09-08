package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.MeasureValueSet;

public interface MeasureValueSetRepository extends JpaRepository<MeasureValueSet, Long>,JpaSpecificationExecutor<MeasureValueSet> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into NCQA_MEASURES_TO_VALUESETS (NCQA_MEASURES_TO_VALUESETS_SEQ, MEASUREMENT_YR, MEASURE_NAME, MEAS_DESC, VALUESET_NAME, VALUESET_OID, CREATE_DT, CREATED_BY, STRATIFICATION_ID) select NCQA_MEASURES_TO_VALUESETS_SEQ.NEXTVAL, :toYear, MEASURE_NAME, MEAS_DESC, VALUESET_NAME, VALUESET_OID, CREATE_DT, CREATED_BY, STRATIFICATION_ID from NCQA_MEASURES_TO_VALUESETS where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete MeasureValueSet where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select ncqaMeasuresToValuesetsSeq, measurementYr, measureName, measDesc, valuesetName, valuesetOid, createDt, createdBy, stratificationId from MeasureValueSet order by ncqaMeasuresToValuesetsSeq";
	String GET_FULL_TABLE = "select ncqaMeasuresToValuesetsSeq, measurementYr, measureName, measDesc, valuesetName, valuesetOid, createDt, createdBy, stratificationId from MeasureValueSet order by ncqaMeasuresToValuesetsSeq";
	String GET_TABLE_FOR_EXPORT = "select measurementYr, measureName, measDesc, valuesetName, valuesetOid, createDt, createdBy, stratificationId from MeasureValueSet order by ncqaMeasuresToValuesetsSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getMeasureValueSetTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getMeasureValueSetFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getMeasureValueSetTableForExport();
}
