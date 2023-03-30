package com.pitchIT.PitchService.models;

import com.pitchIT.PitchService.models.socials.Socials;
import lombok.*;

import javax.persistence.*;
import java.net.URI;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CompanyDetails {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "pitch_id", nullable = false, unique = true)
    private Pitch pitch;

    private String name;
    private String registrationNumber;
    private String country;
    private String registeredCompanyName;
    private String sector;
    private String businessGrowthStage;

    @Transient
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
}
