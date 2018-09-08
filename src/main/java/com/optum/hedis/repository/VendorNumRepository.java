package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.VendorNum;

public interface VendorNumRepository extends JpaRepository<VendorNum, Long>,JpaSpecificationExecutor<VendorNum> {
	String DELETE_MEASURE_IN_TABLE = "delete VendorEvent where measureName = :measureName";
	String GET_TABLE = "select hdeVendorNumXwalkSeq, vendorKey, vendorId, measureName, stratificationId, createDt, createdBy, vendorSubMeasure from VendorNum order by hdeVendorNumXwalkSeq";
	String GET_FULL_TABLE = "select hdeVendorNumXwalkSeq, vendorKey, vendorId, measureName, stratificationId, createDt, createdBy, vendorSubMeasure from VendorNum order by hdeVendorNumXwalkSeq";
	String GET_TABLE_FOR_EXPORT = "select vendorKey, vendorId, measureName, stratificationId, createDt, createdBy, vendorSubMeasure from VendorNum order by hdeVendorNumXwalkSeq";
	
	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName);
	
	@Query(value = GET_TABLE)
	List<Object[]> getVendorNumTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getVendorNumFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getVendorNumTableForExport();
}
