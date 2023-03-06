package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.example.demo.Enum.Location;
import com.example.demo.Enum.ProductStage;
import com.example.demo.Enum.SEISPreference;
import com.example.demo.Enum.CustomerGroup;
import com.example.demo.Enum.Industry;
import com.example.demo.Enum.InvestmentStage;


@Entity
public class Preferences {
    
    private @Id @GeneratedValue Long id;

    @Enumerated
    private Industry industry;

    @Enumerated
    private Location location;

    @Enumerated
    private ProductStage productStage;

    @Enumerated
    private CustomerGroup customerGroup;

    @Enumerated
    private InvestmentStage investmentStage;

    @Enumerated
    private SEISPreference seisPreference;

    public Preferences(Industry industry, Location location, ProductStage productStage, CustomerGroup customerGroup,
            InvestmentStage investmentStage, SEISPreference seisPreference) {
        this.industry = industry;
        this.location = location;
        this.productStage = productStage;
        this.customerGroup = customerGroup;
        this.investmentStage = investmentStage;
        this.seisPreference = seisPreference;
    }


    public Preferences() {
    }


    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public ProductStage getProductStage() {
        return productStage;
    }

    public void setProductStage(ProductStage productStage) {
        this.productStage = productStage;
    }

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }

    public InvestmentStage getInvestmentStage() {
        return investmentStage;
    }

    public void setInvestmentStage(InvestmentStage investmentStage) {
        this.investmentStage = investmentStage;
    }

    public SEISPreference getSeisPreference() {
        return seisPreference;
    }

    public void setSeisPreference(SEISPreference seisPreference) {
        this.seisPreference = seisPreference;
    }
}
