package com.waxes27.pitchIT.appUserTypes.investor.repository;

import com.waxes27.pitchIT.appUserTypes.investor.InvestorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<InvestorModel,Long> {
}
