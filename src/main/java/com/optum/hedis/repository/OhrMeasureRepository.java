package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.MeasureDetailDefAcc;
import com.optum.hedis.domain.OhrMeasure;

public interface OhrMeasureRepository extends JpaRepository<OhrMeasure, Long>,JpaSpecificationExecutor<OhrMeasure> {
	//String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASUERE_TABLE = "insert into MEASURE(MEASURE_ID, MEASURE_CODE, MEASURE_NAME, MEASURE_YEAR, DOMAINID, HASHYBRID, ISACTIVE, ISCOMMERCIAL, ISMEDICAID, ISMEDICARE, ISMARKETPLACE, ISSNP, NUMCNT, RUNTYPE, STORETYPE, SUBDOMAINID, ISSTARS, ISNONHEDIS, SOURCE_TYPE, MANUAL_ENTRY_IND, ISPLD, CREAT_USER, CREAT_TMSTMP, UPDT_USER, UPDT_TMSTMP, P4P_MEASURE_CODE) select MEASURE_ID, MEASURE_CODE, MEASURE_NAME, :toYear, DOMAINID, HASHYBRID, ISACTIVE, ISCOMMERCIAL, ISMEDICAID, ISMEDICARE, ISMARKETPLACE, ISSNP, NUMCNT, RUNTYPE, STORETYPE, SUBDOMAINID, ISSTARS, ISNONHEDIS, SOURCE_TYPE, MANUAL_ENTRY_IND, ISPLD, CREAT_USER, CREAT_TMSTMP, UPDT_USER, UPDT_TMSTMP, P4P_MEASURE_CODE from MEASURE where MEASURE_YEAR = :fromYear";
	String DELETE_MEASURE_TABLE = "delete OhrMeasure where measureId = :measureId and measureYear = :selectedYearToDeleteMeasure";
	String GET_MEASURE_TABLE = "select '',MEASURE_CODE, MEASURE_NAME, MEASURE_YEAR, DOMAINID, HASHYBRID, ISACTIVE, ISCOMMERCIAL, ISMEDICAID, ISMEDICARE, ISMARKETPLACE, ISSNP, NUMCNT, RUNTYPE, STORETYPE, SUBDOMAINID, ISSTARS,SOURCE_TYPE, MANUAL_ENTRY_IND, ISPLD,P4P_MEASURE_CODE from MEASURE order by MEASURE_ID";
	String GET_MEASURE_FULL_TABLE = "select '',MEASURE_ID, MEASURE_CODE, MEASURE_NAME, MEASURE_YEAR, DOMAINID, HASHYBRID, ISACTIVE, ISCOMMERCIAL, ISMEDICAID, ISMEDICARE, ISMARKETPLACE, ISSNP, NUMCNT, RUNTYPE, STORETYPE, SUBDOMAINID, ISSTARS, ISNONHEDIS, SOURCE_TYPE, MANUAL_ENTRY_IND, ISPLD, CREAT_USER, CREAT_TMSTMP, UPDT_USER, UPDT_TMSTMP, P4P_MEASURE_CODE from MEASURE order by MEASURE_ID";
	String GET_MEASURE_TABLE_FOR_EXPORT = "select * from MEASURE";

	/*@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASUERE_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);*/
	
	@Query(value = DELETE_MEASURE_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureId") Long measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_MEASURE_TABLE, nativeQuery = true)
	List<Object[]> getohrMeasureTable();
	
	@Query(value = GET_MEASURE_FULL_TABLE, nativeQuery = true)
	List<Object[]> getohrMeasureFullTable();
	
	@Query(value = GET_MEASURE_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getohrMeasureTableForExport();
}

