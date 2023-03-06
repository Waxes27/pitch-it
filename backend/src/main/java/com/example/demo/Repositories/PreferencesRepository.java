package com.example.demo.Repositories;

import com.example.demo.Models.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
    
}
