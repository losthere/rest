package com.optum.hedis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.optum.hedis.domain.Users;

@Repository
@Component
public interface UsersListRepository extends JpaRepository<Users, Long>,JpaSpecificationExecutor<Users> {
	String USERS = "select emailId, username, password, userrole, isAuthorize from Users";
	String USERS_AUTHORISATION = "update XWALK_USERS set IS_AUTHORIZE = 1 WHERE EMAIL_ID = :emailId";
	String USERS_DELETION = "delete XWALK_USERS WHERE EMAIL_ID = :emailId";
	
	@Query(value = USERS)
	List<Object[]> getUsersCredentials();
	
	@Query(value = USERS_AUTHORISATION, nativeQuery=true) 
	@Modifying
	void confirmOnUserAuthorisation(@Param("emailId") String emailId);
	
	@Query(value = USERS_DELETION, nativeQuery=true) 
	@Modifying
	void confirmOnUserDeletion(@Param("emailId") String emailId);
	
}