package com.pitchIt.pitchIt.preference.repositories;

import com.pitchIt.pitchIt.preference.entities.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrefencesRepository extends JpaRepository<UserPreference, Long> {


}
