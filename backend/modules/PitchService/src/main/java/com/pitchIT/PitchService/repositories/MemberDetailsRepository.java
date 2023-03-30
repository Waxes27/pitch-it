package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.MemberDetails;
import com.pitchIT.PitchService.models.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Long> {
}
