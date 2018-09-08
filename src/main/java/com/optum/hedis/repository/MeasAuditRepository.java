package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.MeasAudit;

public interface MeasAuditRepository extends JpaRepository<MeasAudit, Long>,JpaSpecificationExecutor<MeasAudit> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE = "insert into OHM_MEAS_CODES (MEASUREMENT_YR, MEASURE_NAME, TYPE, CODE, DESCR, IS_ACTIVE, CLIENT_KEY, CREATED_DT, CREATED_BY, UPDATED_DT, UPDATED_BY) select :toYear, MEASURE_NAME, TYPE, CODE, DESCR, IS_ACTIVE, CLIENT_KEY, CREATED_DT, CREATED_BY, UPDATED_DT, UPDATED_BY from OHM_MEAS_CODES where MEASUREMENT_YR = :fromYear and measure_name =:measureCode";
	String DELETE_MEASURE_IN_TABLE = "delete MeasAudit where id.measureName = :measureName and id.measurementYr = :selectedYearToDeleteMeasure";
	String GET_TABLE = "select m.id.measurementYr, m.id.measurementYr, m.id.measureName, m.id.type, m.id.code, descr, isActive, clientKey, createDt, createdBy, updateDt, updatedBy from MeasCodes m";
	String GET_FULL_TABLE = "select m.id.measurementYr, m.id.measurementYr, m.id.measureName, m.id.type, m.id.code, descr, isActive, clientKey, createDt, createdBy, updateDt, updatedBy from MeasCodes m";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_TABLE)
	List<Object[]> getMeasAuditTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getMeasAuditFullTable();
}

