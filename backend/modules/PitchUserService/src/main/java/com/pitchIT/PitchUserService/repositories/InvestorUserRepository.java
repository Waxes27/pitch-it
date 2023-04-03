package com.pitchIT.PitchUserService.repositories;

import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestorUserRepository extends JpaRepository<PitchInvestorUser,Long> {

    Optional<PitchInvestorUser> findByEmail(String email);
}
