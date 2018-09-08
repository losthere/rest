package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>,JpaSpecificationExecutor<Claim> {
	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_CLAIM_TABLE = "insert into HDE_CLAIM_ID_XWALK (HDE_CLAIM_ID_XWALK_SEQ, MEASURE_NAME, NUMERATOR_ID, DEN_CLAIM_METRIC_CODE, NUM_CLAIM_METRIC_CODE, EXCLUSION_CLAIM_METRIC_CODE, REPORTING_YR) select HDE_CLAIM_ID_XWALK_SEQ.NEXTVAL, MEASURE_NAME, NUMERATOR_ID, DEN_CLAIM_METRIC_CODE, NUM_CLAIM_METRIC_CODE, EXCLUSION_CLAIM_METRIC_CODE, :toYear from HDE_CLAIM_ID_XWALK where REPORTING_YR = :fromYear and measure_name = :measureCode";
	String DELETE_MEASURE_IN_CLAIM_TABLE = "delete Claim where measureName = :measureName and reportingYr = :selectedYearToDeleteMeasure";
	String GET_CLAIM_TABLE = "select hdeClaimIdXWalkSeq, measureName, numeratorId, denClaimMetricCode, numClaimMetricCode, exclusionClaimMetricCode, reportingYr from Claim order by hdeClaimIdXWalkSeq";
	String GET_CLAIM_FULL_TABLE = "select hdeClaimIdXWalkSeq, measureName, numeratorId, denClaimMetricCode, numClaimMetricCode, exclusionClaimMetricCode, reportingYr from Claim order by hdeClaimIdXWalkSeq";
	String GET_CLAIM_TABLE_FOR_EXPORT = "select measureName, numeratorId, denClaimMetricCode, numClaimMetricCode, exclusionClaimMetricCode, reportingYr from Claim order by hdeClaimIdXWalkSeq";

	@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_CLAIM_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear, @Param("measureCode") String measureCode);
	
	@Query(value = DELETE_MEASURE_IN_CLAIM_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
	@Query(value = GET_CLAIM_TABLE)
	List<Object[]> getClaimTable();
	
	
	@Query(value = GET_CLAIM_FULL_TABLE)
	List<Object[]> getClaimFullTable();
	
	@Query(value = GET_CLAIM_TABLE_FOR_EXPORT)
	List<Object[]> getClaimTableForExport();
}
