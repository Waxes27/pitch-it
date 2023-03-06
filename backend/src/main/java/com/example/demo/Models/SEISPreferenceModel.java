package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SEISPreferenceModel {

    private @Id @GeneratedValue Long id;
    private @Column String seisPreference;

    public SEISPreferenceModel(String seisPreference) {
        this.seisPreference = seisPreference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeisPreference() {
        return seisPreference;
    }

    public void setSeisPreference(String seisPreference) {
        this.seisPreference = seisPreference;
    }
}
