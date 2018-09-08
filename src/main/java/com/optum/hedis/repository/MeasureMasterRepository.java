package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.MeasureMaster;

@Repository
public interface MeasureMasterRepository extends JpaRepository<MeasureMaster, Long>,JpaSpecificationExecutor<MeasureMaster> {
//	String COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_TABLE = "insert into NCQA_MEASURES (NCQA_MEASURES_SEQ, MEASUREMENT_YR, MEASURE_NAME, MEASURE_DESCR, IS_ACTIVE, HAS_HYBRID, IS_COMMERCIAL, IS_MEDICAID, IS_MEDICARE, IS_SNP, NUMERATOR_COUNT, RUN_TYPE, STORE_TYPE, IS_STARS, DOMAIN_ID, SUB_DOMAIN_ID, SOURCE_TYPE, CREATE_DT, CREATED_BY, IS_REPORTABLE, IS_MARKETPLACE, HYB_MEDICAID, HYB_MEDICARE, HYB_MARKETPLACE, HYB_SNP, HYB_COMMERCIAL) select NCQA_MEASURES_SEQ.NEXTVAL, :toYear, MEASURE_NAME, MEASURE_DESCR, IS_ACTIVE, HAS_HYBRID, IS_COMMERCIAL, IS_MEDICAID, IS_MEDICARE, IS_SNP, NUMERATOR_COUNT, RUN_TYPE, STORE_TYPE, IS_STARS, DOMAIN_ID, SUB_DOMAIN_ID, SOURCE_TYPE, CREATE_DT, CREATED_BY, IS_REPORTABLE, IS_MARKETPLACE, HYB_MEDICAID, HYB_MEDICARE, HYB_MARKETPLACE, HYB_SNP, HYB_COMMERCIAL from NCQA_MEASURES where MEASUREMENT_YR = :fromYear";
	String DELETE_MEASURE_IN_MEASURE_MASTER_TABLE = "delete MeasureMaster where measureName = :measureName and measureYear = :selectedYearToDeleteMeasure";
	String GET_MEASURE_ID = "select MEASURE_ID from MEASURE_MASTER where MEASURE_CODE = :measureName and MEASURE_YEAR = :selectedYearToDeleteMeasure";
	String GET_MEASURE_MASTER_TABLE = "select '',MEASURE_ID,MEASURE_CODE,MEASURE_NAME,MEASURE_YEAR,DOMAINID,HASHYBRID,ISACTIVE,ISCOMMERCIAL,ISMEDICAID,ISMEDICARE,ISMARKETPLACE,ISSNP,NUMCNT,RUNTYPE,STORETYPE,SUBDOMAINID,ISSTARS,ISNONHEDIS,SOURCE_TYPE,MANUAL_ENTRY_IND,ISPLD,CREAT_USER,CREAT_TMSTMP,UPDT_USER,UPDT_TMSTMP,P4P_MEASURE_CODE from MEASURE_MASTER order by MEASURE_ID";
	String GET_MEASURE_MASTER_FULL_TABLE = "select '',MEASURE_ID,MEASURE_CODE,MEASURE_NAME,MEASURE_YEAR,DOMAINID,HASHYBRID,ISACTIVE,ISCOMMERCIAL,ISMEDICAID,ISMEDICARE,ISMARKETPLACE,ISSNP,NUMCNT,RUNTYPE,STORETYPE,SUBDOMAINID,ISSTARS,ISNONHEDIS,SOURCE_TYPE,MANUAL_ENTRY_IND,ISPLD,CREAT_USER,CREAT_TMSTMP,UPDT_USER,UPDT_TMSTMP,P4P_MEASURE_CODE from MEASURE_MASTER order by MEASURE_ID";
	String GET_MEASURE_MASTER_TABLE_FOR_EXPORT = "select * from MEASURE_MASTER";
	String GET_MEASURE_FROM_MEASURE_MASTER_TABLE = "select MEASURE_ID,MEASURE_CODE from MEASURE_MASTER where MEASURE_YEAR = :measureYearForMeasureCode";

	/*@Query(value = COPY_MEASURE_FROM_CURRENT_YEAR_TO_NEXT_YEAR_IN_MEASURE_TABLE, nativeQuery = true)
	@Modifying
	void copyMeasure(@Param("fromYear") Long fromYear, @Param("toYear") Long toYear);*/
	
	@Query(value = DELETE_MEASURE_IN_MEASURE_MASTER_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureId, @Param("selectedYearToDeleteMeasure") String selectedYearToDeleteMeasure);
	
	@Query(value = GET_MEASURE_FROM_MEASURE_MASTER_TABLE, nativeQuery = true)
	List<Object[]> getAllMeasureFromDefFiles(@Param("measureYearForMeasureCode") Long measureYearForMeasureCode);
	
	@Query(value = GET_MEASURE_MASTER_TABLE, nativeQuery = true)
	List<Object[]> getMeasureMasterTable();
	
	@Query(value = GET_MEASURE_MASTER_FULL_TABLE, nativeQuery = true)
	List<Object[]> getMeasureMasterFullTable();
	
	@Query(value = GET_MEASURE_MASTER_TABLE_FOR_EXPORT, nativeQuery = true)
	List<Object[]> getMeasureMasterTableForExport();
	
	@Query(value = GET_MEASURE_ID, nativeQuery = true)
	Long getMeasureId(@Param("measureName") String measureName, @Param("selectedYearToDeleteMeasure") Long selectedYearToDeleteMeasure);
	
}
