package com.pitchIT.PitchService.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pitch {
    private boolean passedQuestion;


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private CompanyDetails companyDetails;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private BusinessDetails businessDetails;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private MarketDetails marketDetails;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Documents documents;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private MemberDetails memberDetails;

    public Pitch(boolean passedQuestion, CompanyDetails companyDetails, BusinessDetails businessDetails, MarketDetails marketDetails, Documents documents, MemberDetails memberDetails) {
        this.passedQuestion = passedQuestion;
        this.companyDetails = companyDetails;
        this.businessDetails = businessDetails;
        this.marketDetails = marketDetails;
        this.documents = documents;
        this.memberDetails = memberDetails;
    }
}
