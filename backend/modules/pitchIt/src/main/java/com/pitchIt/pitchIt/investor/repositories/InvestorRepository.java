package com.pitchIt.pitchIt.investor.repositories;

import com.pitchIt.pitchIt.investor.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvestorRepository extends JpaRepository<Investor, Long> {

    @Query(value = "SELECT * FROM INVESTOR WHERE EMAIL=:#{#email}", nativeQuery = true)
    Investor findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM INVESTOR WHERE EMAIL=:#{#email} AND PASSWORD=:#{#password}", nativeQuery = true)
    Investor signIn(@Param("email") String email, @Param("password") String password);
}
