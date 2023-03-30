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




    public void savePitch(
            BusinessDetails businessDetails,
            CompanyDetails companyDetails,
            Documents documents,
            MarketDetails marketDetails,
            MemberDetails memberDetails
    ){
        Pitch pitch = Pitch.builder()
            .businessDetails(businessDetailsRepository.save(businessDetails))
            .companyDetails(companyDetailsRepository.save(companyDetails))
            .documents(documentsRepository.save(documents))
            .marketDetails(marketDetailsRepository.save(marketDetails))
            .memberDetails(memberDetailsRepository.save(memberDetails))
            .build();

        pitchRepository.save(pitch);
    }


}
