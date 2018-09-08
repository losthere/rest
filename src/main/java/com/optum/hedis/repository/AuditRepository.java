package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.optum.hedis.domain.Audit;


@Repository
@Component
public interface AuditRepository extends JpaRepository<Audit, Long>,JpaSpecificationExecutor<Audit> {

	String AUDIT = "select username,timestamp,measure,operation from Audit";

	@Query(value = AUDIT)
	List<Object[]> getAudit();
}