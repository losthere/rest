package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long>,JpaSpecificationExecutor<Measure> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_TABLE = "insert into NCQA_MEASURES (NCQA_MEASURES_SEQ, MEASUREMENT_YR, MEASURE_NAME, MEASURE_DESCR, IS_ACTIVE, HAS_HYBRID, IS_COMMERCIAL, IS_MEDICAID, IS_MEDICARE, IS_SNP, NUMERATOR_COUNT, RUN_TYPE, STORE_TYPE, IS_STARS, DOMAIN_ID, SUB_DOMAIN_ID, SOURCE_TYPE, CREATE_DT, CREATED_BY, IS_REPORTABLE, IS_MARKETPLACE, HYB_MEDICAID, HYB_MEDICARE, HYB_MARKETPLACE, HYB_SNP, HYB_COMMERCIAL) select NCQA_MEASURES_SEQ.NEXTVAL, :toYear, MEASURE_NAME, MEASURE_DESCR, IS_ACTIVE, HAS_HYBRID, IS_COMMERCIAL, IS_MEDICAID, IS_MEDICARE, IS_SNP, NUMERATOR_COUNT, RUN_TYPE, STORE_TYPE, IS_STARS, DOMAIN_ID, SUB_DOMAIN_ID, SOURCE_TYPE, CREATE_DT, CREATED_BY, IS_REPORTABLE, IS_MARKETPLACE, HYB_MEDICAID, HYB_MEDICARE, HYB_MARKETPLACE, HYB_SNP, HYB_COMMERCIAL from NCQA_MEASURES where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_MEASURE_TABLE = "delete Measure where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_ALL_MEASURES = "select distinct measureName from Measure order by measureName";
	String GET_MEASURE_TABLE = "select ncqaMeasuresSeq, measurementYr, measureName, measureDescr, isActive, hasHybrid, isCommercial, isMedicaid, isMedicare, isSnp, numeratorCount, runType, storeType, isStars, domainId, subDomainId, sourceType, createDt, createdBy, isReportable, isMarketPlace, hybMedicaid, hybMedicare, hybMarketPlace, hybSnp, hybCommercial from Measure order by ncqaMeasuresSeq";
	String GET_MEASURE_FULL_TABLE = "select ncqaMeasuresSeq, measurementYr, measureName, measureDescr, isActive, hasHybrid, isCommercial, isMedicaid, isMedicare, isSnp, numeratorCount, runType, storeType, isStars, domainId, subDomainId, sourceType, createDt, createdBy, isReportable, isMarketPlace, hybMedicaid, hybMedicare, hybMarketPlace, hybSnp, hybCommercial from Measure order by ncqaMeasuresSeq";
	String GET_MEASURE_TABLE_FOR_EXPORT = "select measurementYr, measureName, measureDescr, isActive, hasHybrid, isCommercial, isMedicaid, isMedicare, isSnp, numeratorCount, runType, storeType, isStars, domainId, subDomainId, sourceType, createDt, createdBy, isReportable, isMarketPlace, hybMedicaid, hybMedicare, hybMarketPlace, hybSnp, hybCommercial from Measure order by ncqaMeasuresSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear , @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_MEASURE_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_ALL_MEASURES)
	List<String> getAllMeasures();
	
	@Query(value = GET_MEASURE_TABLE)
	List<Object[]> getMeasureTable();
	
	@Query(value = GET_MEASURE_FULL_TABLE)
	List<Object[]> getMeasureFullTable();
	
	@Query(value = GET_MEASURE_TABLE_FOR_EXPORT)
	List<Object[]> getMeasureTableForExport();
}
