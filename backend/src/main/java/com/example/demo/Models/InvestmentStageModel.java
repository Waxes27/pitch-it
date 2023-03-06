package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class InvestmentStageModel {

    private @Id @GeneratedValue Long id;
    private @Column String investmentStage;


    public InvestmentStageModel(String investmentStage) {
        this.investmentStage = investmentStage;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getInvestmentStage() {
        return investmentStage;
    }


    public void setInvestmentStage(String investmentStage) {
        this.investmentStage = investmentStage;
    }    
}
