package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.example.demo.Enum.Location;

@Entity
public class Preferences {
    
    private @Id @GeneratedValue Long id;

    // @OneToOne 
    // @JoinColumn(name = "industry")
    // private Industry industry;

    // @OneToOne 
    // @JoinColumn(name = "location")
    @Enumerated
    private Location location;

    public Preferences() {
    }

    public Preferences(Industry industry, Location location) {
        // this.industry = industry;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Industry getIndustry() {
    //     return industry;
    // }

    // public void setIndustry(Industry industry) {
    //     this.industry = industry;
    // }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
