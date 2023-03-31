package com.pitchIT.PitchService.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pitch {
    private boolean passedQuestion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, orphanRemoval = true)
    private CompanyDetails companyDetails;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, orphanRemoval = true)
    private BusinessDetails businessDetails;


    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, orphanRemoval = true)
    private MarketDetails marketDetails;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Documents documents;

    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL, orphanRemoval = true)
    private MemberDetails memberDetails;



    public Pitch(boolean passedQuestion, CompanyDetails companyDetails, BusinessDetails businessDetails, MarketDetails marketDetails, Documents documents, MemberDetails memberDetails) {
        this.passedQuestion = passedQuestion;
        this.companyDetails = companyDetails;
        this.businessDetails = businessDetails;
        this.marketDetails = marketDetails;
        this.documents = documents;
        this.memberDetails = memberDetails;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id:").append(id);
        sb.append(", companyDetails:").append(companyDetails);
        sb.append('}');
        return sb.toString();
    }
}
