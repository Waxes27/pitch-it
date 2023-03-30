package com.pitchIT.PitchService.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pitch {
    private boolean passedQuestion;


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private CompanyDetails companyDetails;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private BusinessDetails businessDetails;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private MarketDetails marketDetails;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Documents documents;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private MemberDetails memberDetails;

}
