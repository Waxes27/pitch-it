package com.pitchIt.pitchIt.repositories;

import com.pitchIt.pitchIt.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessRepository extends JpaRepository<Business, Long> {

 @Query(value = "SELECT * FROM BUSINESS WHERE REP_EMAIL=:#{#email} AND REP_PASSWORD=:#{#password}", nativeQuery = true)
 Business findByEmail(@Param("email") String email, @Param("password") String password);

 @Query(value = "SELECT * FROM BUSINESS WHERE REP_EMAIL=:#{#email} OR BUSINESS_NAME=:#{#name}", nativeQuery = true)
 Business findByExisting(@Param("email") String email, @Param("name") String password);

 @Query(value = "SELECT * FROM BUSINESS WHERE REP_EMAIL=:#{#email}", nativeQuery = true)
 Business findByEmail(@Param("email") String email);

 @Query(value = "SELECT * FROM BUSINESS WHERE BUSINESS_NAME=:#{#name}", nativeQuery = true)
 Business findByBusinessName(@Param("name") String email);
}
