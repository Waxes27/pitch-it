package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class IndustryModel {
    
    private @Id @GeneratedValue Long id;
    private @Column String industryName;


    public IndustryModel() {
    }


    public IndustryModel(String industryName) {
        this.industryName = industryName;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getIndustryName() {
        return industryName;
    }


    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
    
}
