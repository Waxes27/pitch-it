package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LocationModel {
 
    private @Id @GeneratedValue Long id;
    
    private @Column String locationName;


    public LocationModel() {
    }


    public LocationModel(String locationName) {
        this.locationName = locationName;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getLocationName() {
        return locationName;
    }

    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
