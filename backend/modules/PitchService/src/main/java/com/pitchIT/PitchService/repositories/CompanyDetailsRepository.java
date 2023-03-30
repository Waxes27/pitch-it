package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long> {
}
