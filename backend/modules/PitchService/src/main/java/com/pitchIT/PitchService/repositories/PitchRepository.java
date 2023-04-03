package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Long> {

    @Override
    Optional<Pitch> findById(Long userId);
}
