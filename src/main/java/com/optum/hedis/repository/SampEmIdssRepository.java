package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.SampEmIdss;

public interface SampEmIdssRepository extends JpaRepository<SampEmIdss, Long>,JpaSpecificationExecutor<SampEmIdss> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into SAMP_EM_IDSS_XWALK (SAMP_EM_IDSS_XWALK_SEQ, MEASUREMENT_YR, MEASURE_NAME, SAMP_IDSS_ELEMENT, CREATED_DT, CREATED_BY, UPDATED_DT, UPDATED_BY) select SAMP_EM_IDSS_XWALK_SEQ.NEXTVAL, :toYear, MEASURE_NAME, SAMP_IDSS_ELEMENT, CREATED_DT, CREATED_BY, UPDATED_DT, UPDATED_BY from SAMP_EM_IDSS_XWALK where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete SampEmIdss where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select sampEmIdssXwalkSeq, measurementYr, measureName, sampIdssElement, createDt, createdBy, updateDt, updatedBy from SampEmIdss order by sampEmIdssXwalkSeq";
	String GET_FULL_TABLE = "select sampEmIdssXwalkSeq, measurementYr, measureName, sampIdssElement, createDt, createdBy, updateDt, updatedBy from SampEmIdss order by sampEmIdssXwalkSeq";
	String GET_TABLE_FOR_EXPORT = "select measurementYr, measureName, sampIdssElement, createDt, createdBy, updateDt, updatedBy from SampEmIdss order by sampEmIdssXwalkSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear,@Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getSampEmIdssTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getSampEmIdssFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getSampEmIdssTableForExport();
}

