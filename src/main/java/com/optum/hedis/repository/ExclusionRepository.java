package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.Exclusion;

@Repository
public interface ExclusionRepository extends JpaRepository<Exclusion, Long>,JpaSpecificationExecutor<Exclusion> {
	String DELETE_MEASURE_IN_EXCLUSION_TABLE = "delete Exclusion where measureName = :measureName";
	String GET_EXCLUSION_TABLE = "select hdeExclusionsXWalkSeq, measureName, numeratorId, exclusionType from Exclusion order by hdeExclusionsXWalkSeq";
	String GET_EXCLUSION_FULL_TABLE = "select hdeExclusionsXWalkSeq, measureName, numeratorId, exclusionType from Exclusion order by hdeExclusionsXWalkSeq";
	String GET_EXCLUSION_TABLE_FOR_EXPORT = "select measureName, numeratorId, exclusionType from Exclusion order by hdeExclusionsXWalkSeq";

	@Query(value = DELETE_MEASURE_IN_EXCLUSION_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName);
	
	@Query(value = GET_EXCLUSION_TABLE)
	List<Object[]> getExclusionTable();
	
	@Query(value = GET_EXCLUSION_FULL_TABLE)
	List<Object[]> getExclusionFullTable();
	
	@Query(value = GET_EXCLUSION_TABLE_FOR_EXPORT)
	List<Object[]> getExclusionTableForExport();
}
