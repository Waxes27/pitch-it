package com.pitchIT.PitchService.services;

import com.pitchIT.PitchService.models.*;
import com.pitchIT.PitchService.models.socials.Socials;
import com.pitchIT.PitchService.repositories.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            String username,
            BusinessDetails businessDetails,
            CompanyDetails companyDetails,
            Documents documents,
            MarketDetails marketDetails,
            MemberDetails memberDetails
    ) {

        Pitch pitch = new Pitch();

        businessDetails.setPitch(pitch);
        companyDetails.setPitch(pitch);
        documents.setPitch(pitch);
        marketDetails.setPitch(pitch);
        memberDetails.setPitch(pitch);

        businessDetailsRepository.save(businessDetails);
        documentsRepository.save(documents);
        marketDetailsRepository.save(marketDetails);
        memberDetailsRepository.save(memberDetails);
        pitch.setUsername(username);
        pitch.setCompanyDetails(companyDetails);
        pitch.setBusinessDetails(businessDetails);
        pitch.setDocuments(documents);
        pitch.setMarketDetails(marketDetails);
        pitch.setMemberDetails(memberDetails);
        pitch.setLogoUrl("/assets/pitchIt-logo.png");
        System.out.println(pitch);

        return pitchRepository.save(pitch);

    }

    public List<Optional<Pitch>> getAllPitchByUsername(String username){
        List<Optional<Pitch>> pitches = pitchRepository.findByUsername(username);

        return pitches;
    }

    public List<Pitch> getAllPitches() {
        return pitchRepository.findAll();
    }

    public Optional<Pitch> getPitchByID(Long id) {
        return pitchRepository.findById(id);
    }
}