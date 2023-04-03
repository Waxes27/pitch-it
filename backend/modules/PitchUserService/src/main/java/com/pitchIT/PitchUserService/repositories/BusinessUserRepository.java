package com.pitchIT.PitchUserService.repositories;

import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface BusinessUserRepository extends JpaRepository<PitchBusinessUser,Long> {
    Optional<PitchBusinessUser> findByEmail(String email);

}