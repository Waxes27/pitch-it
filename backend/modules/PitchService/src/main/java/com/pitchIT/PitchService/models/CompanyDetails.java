package com.pitchIT.PitchService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pitchIT.PitchService.models.socials.Socials;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pitch_id")
    @JsonIgnore
    private Pitch pitch;

    private String name;
    private String registrationNumber;
    private String country;
    private String registeredCompanyName;
    private String sector;
    private String businessGrowthStage;


    @OneToOne(mappedBy = "companyDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Socials socials;

    public CompanyDetails(String name, String registrationNumber, String country, String registeredCompanyName, String sector, String businessGrowthStage, Socials socials) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.country = country;
        this.registeredCompanyName = registeredCompanyName;
        this.sector = sector;
        this.businessGrowthStage = businessGrowthStage;
        this.socials = socials;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id:").append(id);
        sb.append(", name:'").append(name).append('\'');
        sb.append(", registrationNumber:'").append(registrationNumber).append('\'');
        sb.append(", country:'").append(country).append('\'');
        sb.append(", registeredCompanyName:'").append(registeredCompanyName).append('\'');
        sb.append(", sector:'").append(sector).append('\'');
        sb.append(", businessGrowthStage:'").append(businessGrowthStage).append('\'');
        sb.append(", socials:").append(socials);
        sb.append('}');
        return sb.toString();
    }
}
