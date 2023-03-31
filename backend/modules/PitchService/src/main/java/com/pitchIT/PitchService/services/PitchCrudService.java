package com.pitchIT.PitchService.services;

import com.pitchIT.PitchService.models.*;
import com.pitchIT.PitchService.models.socials.Socials;
import com.pitchIT.PitchService.repositories.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PitchCrudService {
    // Repositories Here
    private final PitchRepository pitchRepository;
    private final BusinessDetailsRepository businessDetailsRepository;
    private final CompanyDetailsRepository companyDetailsRepository;
    private final DocumentsRepository documentsRepository;
    private final MarketDetailsRepository marketDetailsRepository;
    private final MemberDetailsRepository memberDetailsRepository;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Pitch savePitch(
            BusinessDetails businessDetails,
            CompanyDetails companyDetails,
            Documents documents,
            MarketDetails marketDetails,
            MemberDetails memberDetails,
            Pitch pitch
    ) {
        companyDetails.setPitch(pitch);
        pitch.setCompanyDetails(companyDetailsRepository.save(companyDetails));

        businessDetailsRepository.save(businessDetails);
        documentsRepository.save(documents);
        marketDetailsRepository.save(marketDetails);
        memberDetailsRepository.save(memberDetails);

        pitch.setBusinessDetails(businessDetails);
        pitch.setDocuments(documents);
        pitch.setMarketDetails(marketDetails);
        pitch.setMemberDetails(memberDetails);

        return pitchRepository.save(pitch);

    }
}