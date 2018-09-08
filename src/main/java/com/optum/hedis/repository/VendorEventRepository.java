
package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optum.hedis.domain.VendorEvent;

public interface VendorEventRepository extends JpaRepository<VendorEvent, Long>,JpaSpecificationExecutor<VendorEvent> {
	String DELETE_MEASURE_IN_TABLE = "delete VendorEvent where measureName = :measureName";
	String GET_TABLE = "select hdeVendorEventXwalkSeq, vendorKey, measureName, subMeasure, eventDescr, metricCode, createDt, createdBy from VendorEvent order by hdeVendorEventXwalkSeq";
	String GET_FULL_TABLE = "select hdeVendorEventXwalkSeq, vendorKey, measureName, subMeasure, eventDescr, metricCode, createDt, createdBy from VendorEvent order by hdeVendorEventXwalkSeq";
	String GET_TABLE_FOR_EXPORT = "select vendorKey, measureName, subMeasure, eventDescr, metricCode, createDt, createdBy from VendorEvent order by hdeVendorEventXwalkSeq";

	@Query(value = DELETE_MEASURE_IN_TABLE)
	@Modifying
	void deleteMeasure(@Param("measureName") String measureName);
	
	@Query(value = GET_TABLE)
	List<Object[]> getVendorEventTable();
	
	@Query(value = GET_FULL_TABLE)
	List<Object[]> getVendorEventFullTable();
	
	@Query(value = GET_TABLE_FOR_EXPORT)
	List<Object[]> getVendorEventTableForExport();
}
