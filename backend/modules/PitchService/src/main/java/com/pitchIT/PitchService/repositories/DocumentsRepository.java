package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {
}
