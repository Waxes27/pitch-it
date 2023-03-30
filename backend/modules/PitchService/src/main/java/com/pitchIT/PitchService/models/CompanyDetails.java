package com.pitchIT.PitchService.models;

import com.pitchIT.PitchService.models.socials.Socials;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.net.URI;

@Entity
@Getter
@Setter
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

}
