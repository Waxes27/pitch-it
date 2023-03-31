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
            MemberDetails memberDetails
    ){
//        Pitch pitch = pitchRepository.save(new Pitch());
//        companyDetails.setPitch(pitch);
//        businessDetails.setPitch(pitch);
        System.out.println(companyDetails);
        companyDetails = companyDetailsRepository.save(companyDetails);
//        companyDetails.setPitch();

        Pitch pitch = Pitch.builder()
                 .companyDetails(companyDetails)
                 .businessDetails(businessDetailsRepository.save(businessDetails))
            .documents(documentsRepository.save(documents))
            .marketDetails(marketDetailsRepository.save(marketDetails))
            .memberDetails(memberDetailsRepository.save(memberDetails))
            .build();

        return pitchRepository.save(pitch);
    }


}
