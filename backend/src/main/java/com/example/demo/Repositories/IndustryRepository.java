package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Industry;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Long> {
    
}
