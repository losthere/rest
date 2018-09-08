package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.OhrNumerator;

public interface OhrNumeratorRepository extends JpaRepository<OhrNumerator, Long>,JpaSpecificationExecutor<OhrNumerator> {
	String DELETE_NUMERATOR_TABLE = "delete OhrNumerator where measureId = :measureId";
	String GET_NUMERATOR_FULL_TABLE = "select '',numeratorId, measureId, numeratorCode, numeratorName, scoreType, benefitid, extident, hasComorbid, isActive, isParent, isShown, parentId, shortDescr, stratageId, stratId, displaySortBy, minValue, maxValue, rateType, rateDataType, trendGraphInd, goalEntryInd, prevCompareInd, numeratorDetail, isMarketPlace, createUser, creatTmstmp, updtUser, updtTmstmp, numCode, isCommercial, isMedicare, isMedicaid, isSnp, p4pMeasureCode from OhrNumerator order by numeratorId";
	String GET_NUMERATOR_TABLE = "select '',m.measure_year, m.measure_code, d.numerator_Code, d.numerator_Name, d.score_Type, d.isActive,  d.shortDescr, d.min_Value, d.max_Value, d.rate_Type, d.trend_Graph_Ind, d.goal_Entry_Ind, d.prev_Compare_Ind,d.numerator_Detail, d.isMarketPlace, d.isCommercial, d.isMedicare, d.isMedicaid, d.isSnp, d.p4p_Measure_Code from Numerator d left join measure m on d.measure_id = m.measure_id";
    String GET_NUMERATOR_TABLE_FOR_EXPORT = "select * from NUMERATOR";

	@Query(value = DELETE_NUMERATOR_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId);
	
	@Query(value = GET_NUMERATOR_TABLE, nativeQuery = true)
	List<Object[]> getohrNumeratorTable();
	
	@Query(value = GET_NUMERATOR_FULL_TABLE)
	List<Object[]> getohrNumeratorFullTable();
	
	@Query(value = GET_NUMERATOR_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getohrNumeratorTableForExport();
}

