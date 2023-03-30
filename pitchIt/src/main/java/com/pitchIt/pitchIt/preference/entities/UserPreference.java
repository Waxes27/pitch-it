package com.pitchIt.pitchIt.preference.entities;

import javax.persistence.*;

@Entity
@Table(name = "PREFERENCES")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID", length = 10, nullable = false)
    private Integer userId;

    @Column(name = "INDUSTRY", length = 20, nullable = false)
    private String industry;

    @Column(name = "LOCATION", length = 20, nullable = false)
    private String location;

    @Column(name = "PRODDEV_STAGE", length = 10, nullable = false)
    private String developmentStage;

    @Column(name = "CUSTOMER_GROUP", length = 20, nullable = false)
    private String customerGroup;

    @Column(name = "INVESTMENT_STAGE", length = 20, nullable = false)
    private String investmentStage;

    @Column(name = "SEIS_EIS_PREF", length = 20, nullable = false)
    private boolean seisPreference;

    public UserPreference() {
    }

    public UserPreference(
            Integer userId,
            String industry,
            String location,
            String developmentStage,
            String customerGroup,
            String investmentStage,
            boolean seisPreference) {
        this.userId = userId;
        this.industry = industry;
        this.location = location;
        this.developmentStage = developmentStage;
        this.customerGroup = customerGroup;
        this.investmentStage = investmentStage;
        this.seisPreference = seisPreference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDevelopmentStage() {
        return developmentStage;
    }

    public void setDevelopmentStage(String developmentStage) {
        this.developmentStage = developmentStage;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getInvestmentStage() {
        return investmentStage;
    }

    public void setInvestmentStage(String investmentStage) {
        this.investmentStage = investmentStage;
    }

    public boolean isSeisPreference() {
        return seisPreference;
    }

    public void setSeisPreference(boolean seisPreference) {
        this.seisPreference = seisPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPreference that = (UserPreference) o;

        if (isSeisPreference() != that.isSeisPreference()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        if (getIndustry() != null ? !getIndustry().equals(that.getIndustry()) : that.getIndustry() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null)
            return false;
        if (getDevelopmentStage() != null ? !getDevelopmentStage().equals(that.getDevelopmentStage()) : that.getDevelopmentStage() != null)
            return false;
        if (getCustomerGroup() != null ? !getCustomerGroup().equals(that.getCustomerGroup()) : that.getCustomerGroup() != null)
            return false;
        return getInvestmentStage() != null ? getInvestmentStage().equals(that.getInvestmentStage()) : that.getInvestmentStage() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getIndustry() != null ? getIndustry().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getDevelopmentStage() != null ? getDevelopmentStage().hashCode() : 0);
        result = 31 * result + (getCustomerGroup() != null ? getCustomerGroup().hashCode() : 0);
        result = 31 * result + (getInvestmentStage() != null ? getInvestmentStage().hashCode() : 0);
        result = 31 * result + (isSeisPreference() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "id=" + id +
                ", userId=" + userId +
                ", industry='" + industry + '\'' +
                ", location='" + location + '\'' +
                ", developmentStage='" + developmentStage + '\'' +
                ", customerGroup='" + customerGroup + '\'' +
                ", investmentStage='" + investmentStage + '\'' +
                ", seisPreference=" + seisPreference +
                '}';
    }
}
