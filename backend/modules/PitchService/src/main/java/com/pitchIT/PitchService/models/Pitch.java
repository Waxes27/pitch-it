package com.pitchIT.PitchService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.json.JSONObject;

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
    private String username;
    private String logoUrl;

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


//    public Pitch(String username, CompanyDetails companyDetails, BusinessDetails businessDetails, MarketDetails marketDetails, Documents documents, MemberDetails memberDetails) {
//        this.passedQuestion = true;
//        this.companyDetails = companyDetails;
//        this.businessDetails = businessDetails;
//        this.marketDetails = marketDetails;
//        this.documents = documents;
//        this.memberDetails = memberDetails;
//        this.username = username;
//    }

    public Pitch(boolean passedQuestion, String username, CompanyDetails companyDetails, BusinessDetails businessDetails, MarketDetails marketDetails, Documents documents, MemberDetails memberDetails) {
        this.passedQuestion = passedQuestion;
        this.username = username;
        this.logoUrl = "/assets/pitchIt-logo.png";
        this.companyDetails = companyDetails;
        this.businessDetails = businessDetails;
        this.marketDetails = marketDetails;
        this.documents = documents;
        this.memberDetails = memberDetails;
    }


//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("{");
//        sb.append("passedQuestion:").append(passedQuestion);
//        sb.append(", id:").append(id);
//        sb.append(", username:'").append(username).append('\'');
//        sb.append(", companyDetails:").append(companyDetails);
//        sb.append(", businessDetails:").append(businessDetails);
//        sb.append(", marketDetails:").append(marketDetails);
//        sb.append(", documents:").append(documents);
//        sb.append(", memberDetails:").append(memberDetails);
//        sb.append('}');
//        return sb.toString();
//    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("passedQuestion:").append(passedQuestion);
        sb.append(", id:").append(id);
        sb.append(", username:'").append(username).append('\'');
        sb.append(", logoUrl:'").append(logoUrl).append('\'');
        sb.append(", companyDetails:").append(companyDetails);
        sb.append(", businessDetails:").append(businessDetails);
        sb.append(", marketDetails:").append(marketDetails);
        sb.append(", documents:").append(documents);
        sb.append(", memberDetails:").append(memberDetails);
        sb.append('}');
        return sb.toString();
    }
}
