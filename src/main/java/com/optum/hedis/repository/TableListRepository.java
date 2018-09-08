package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.TableList;

@Repository
public interface TableListRepository extends JpaRepository<TableList, Long>,JpaSpecificationExecutor<TableList> {
	String ALL_XWALK_TABLES = "select TABLE_NAME from TABLE_LIST where TABLE_TYPE = 'X-WALK TABLE' order by TABLE_NAME";
	String ALL_DEFFILE_TABLES = "select TABLE_NAME from TABLE_LIST where TABLE_TYPE = 'DEF-FILE TABLE' order by TABLE_NAME";

	@Query(value = ALL_XWALK_TABLES , nativeQuery = true)
	List<String> getAllXWalkTables();
	
	@Query(value = ALL_DEFFILE_TABLES , nativeQuery = true)
	List<String> getAllDefFileTables();
	
	
}