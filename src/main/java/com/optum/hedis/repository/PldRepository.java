package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.Pld;

public interface PldRepository extends JpaRepository<Pld, Long>,JpaSpecificationExecutor<Pld> {
	String DELETE_MEASURE_IN_PLD_TABLE = "delete Pld where measureName = :measureName";
	String GET_PLD_TABLE = "select hdePldMeasXWalkSeq, measureName, measureId, stratificationId, denominatorFlag, denominatorExclusionFlag, denominatorExceptionFlag, numeratorFlag, numeratorExclusionFlag, finalFlag, pldColumnName, typeOfExclusion from Pld order by hdePldMeasXWalkSeq";
	String GET_PLD_FULL_TABLE = "select hdePldMeasXWalkSeq, measureName, measureId, stratificationId, denominatorFlag, denominatorExclusionFlag, denominatorExceptionFlag, numeratorFlag, numeratorExclusionFlag, finalFlag, pldColumnName, typeOfExclusion from Pld order by hdePldMeasXWalkSeq";
	String GET_PLD_TABLE_FOR_EXPORT = "select measureName, measureId, stratificationId, denominatorFlag, denominatorExclusionFlag, denominatorExceptionFlag, numeratorFlag, numeratorExclusionFlag, finalFlag, pldColumnName, typeOfExclusion from Pld order by hdePldMeasXWalkSeq";

	@Query(value = DELETE_MEASURE_IN_PLD_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName);
	
	@Query(value = GET_PLD_TABLE)
	List<Object[]> getPldTable();
	
	@Query(value = GET_PLD_FULL_TABLE)
	List<Object[]> getPldFullTable();
	
	@Query(value = GET_PLD_TABLE_FOR_EXPORT)
	List<Object[]> getPldTableForExport();
}