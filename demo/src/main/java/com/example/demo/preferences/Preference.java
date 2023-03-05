package com.example.demo.preferences;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Preference {
    

    private @Id @GeneratedValue Long id;
    private String industry;
    private String location;
    private String productStage;
    private String customerGroup;
    private String investmentStage;
    private String eisPreference;

}
