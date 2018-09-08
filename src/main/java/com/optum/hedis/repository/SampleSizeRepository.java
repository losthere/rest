package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.SampleSize;

public interface SampleSizeRepository extends JpaRepository<SampleSize, Long>,JpaSpecificationExecutor<SampleSize> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into NCQA_SAMPLE_SIZE (NCQA_SAMPLE_SIZE_SEQ, MEASUREMENT_YR, MEASURE_DESC, MEASURE_NAME, MEDICAID, COMMERCIAL, MEDICARE, MKTPL, PY_RATE, RAND, IS_ACTIVE, NOTE, CREATE_DT, CREATED_BY) select NCQA_SAMPLE_SIZE_SEQ.NEXTVAL, :toYear, MEASURE_DESC, MEASURE_NAME, MEDICAID, COMMERCIAL, MEDICARE, MKTPL, PY_RATE, RAND, IS_ACTIVE, NOTE, CREATE_DT, CREATED_BY from NCQA_SAMPLE_SIZE where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete SampleSize where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select ncqaSampleSizeSeq, measurementYr, measureDesc, measureName, medicaid, commercial, medicare, pyRate, rand, isActive, note, createDt, createdBy from SampleSize order by ncqaSampleSizeSeq";
	String GET_FULL_TABLE = "select ncqaSampleSizeSeq, measurementYr, measureDesc, measureName, medicaid, commercial, medicare, pyRate, rand, isActive, note, createDt, createdBy from SampleSize order by ncqaSampleSizeSeq";
	String GET_TABLE_FOR_EXPORT = "select measurementYr, measureDesc, measureName, medicaid, commercial, medicare, pyRate, rand, isActive, note, createDt, createdBy from SampleSize order by ncqaSampleSizeSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear ,@Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getSampleSizeTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getSampleSizeFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getSampleSizeTableForExport();
}
