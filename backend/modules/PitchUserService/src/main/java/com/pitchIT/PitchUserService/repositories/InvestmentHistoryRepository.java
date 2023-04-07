package com.pitchIT.PitchUserService.repositories;

import com.pitchIT.PitchUserService.models.InvestmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvestmentHistoryRepository extends JpaRepository<InvestmentHistory,Long> {

}
