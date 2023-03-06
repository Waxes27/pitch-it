package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.LocationModel;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {
    
}
