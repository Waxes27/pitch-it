package com.pitchIT.PitchService.repositories;

import com.pitchIT.PitchService.models.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Long> {
    List<Optional<Pitch>> findByUsername(String username);



}
