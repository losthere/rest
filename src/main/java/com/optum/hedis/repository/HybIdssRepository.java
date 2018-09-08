package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.HybIdss;

public interface HybIdssRepository extends JpaRepository<HybIdss, Long>,JpaSpecificationExecutor<HybIdss> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into NCQA_HYB_IDSS_XWALK (HYB_IDSS_CW_KEY, MEASUREMENT_YR, MEASURE_NAME, NUMERATOR_ID, STRATIFICATION_ID, PRODUCT_LINE, IDSS_ELEMENT, HYB_ELEMENT_TYPE, ELEMENT_TYPE, AGG_LEVEL, IS_ACTIVE, CREATE_DT, CREATED_BY, NO_OF_NUMERATORS) select HYB_IDSS_CW_KEY, :toYear, MEASURE_NAME, NUMERATOR_ID, STRATIFICATION_ID, PRODUCT_LINE, IDSS_ELEMENT, HYB_ELEMENT_TYPE, ELEMENT_TYPE, AGG_LEVEL, IS_ACTIVE, CREATE_DT, CREATED_BY, NO_OF_NUMERATORS from NCQA_HYB_IDSS_XWALK where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete HybIdss where measureName = :measureName and measurementYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select hybIdssCwKey, hybIdssCwKey, measurementYr, measureName, numeratorId, stratificationId, productLine, idssElement, hybElementType, elementType, aggLevel, isActive, createDt, createdBy, noOfNumerators from HybIdss";
	String GET_FULL_TABLE = "select hybIdssCwKey, hybIdssCwKey, measurementYr, measureName, numeratorId, stratificationId, productLine, idssElement, hybElementType, elementType, aggLevel, isActive, createDt, createdBy, noOfNumerators from HybIdss";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getHybIdssTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getHybIdssFullTable();
}