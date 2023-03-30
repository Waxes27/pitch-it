package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {
}
