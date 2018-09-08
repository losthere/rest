package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.Numerator;
import com.optum.hedis.domain.NumeratorPK;

@Repository
public interface NumeratorRepository extends JpaRepository<Numerator, NumeratorPK>,JpaSpecificationExecutor<Numerator> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_NUMERATOR_TABLE = "insert into NCQA_NUMERATORS (MEASUREMENT_YR, MEASURE_NAME, STRATIFICATION_ID, RPT_DESCR, DESCR, IS_ACTIVE, CREATE_DT, CREATED_BY, IS_REPORTABLE, OHM_DESCR) select :toYear, MEASURE_NAME, STRATIFICATION_ID, RPT_DESCR, DESCR, IS_ACTIVE, CREATE_DT, CREATED_BY, IS_REPORTABLE, OHM_DESCR from NCQA_NUMERATORS where MEASUREMENT_YR = :fromYear";
	String DELETE_MEASURE_IN_NUMERATOR_TABLE = "delete Numerator where measureName = :measureName and id.measurementYr = :selectedYearToDeleteMeasure";
	String GET_NUMERATOR_TABLE = "select n.id.measurementYr, n.id.measurementYr, n.measureName, n.id.stratificationId, n.rptDescr, n.descr, n.isActive, n.createDt, n.createdBy, n.isReportable, n.ohmDescr from Numerator n";
	String GET_NUMERATOR_FULL_TABLE = "select n.id.measurementYr, n.id.measurementYr, n.measureName, n.id.stratificationId, n.rptDescr, n.descr, n.isActive, n.createDt, n.createdBy, n.isReportable, n.ohmDescr from Numerator n";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_NUMERATOR_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);
	
	@Query(value = DELETE_MEASURE_IN_NUMERATOR_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_NUMERATOR_TABLE)
	List<Object[]> getNumeratorTable();
	
	@Query(value = GET_NUMERATOR_FULL_TABLE)
	List<Object[]> getNumeratorFullTable();
}
