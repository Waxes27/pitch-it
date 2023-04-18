package com.pitchIT.PitchUserService.services;


import com.pitchIT.PitchUserService.models.InvestmentHistory;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.repositories.BusinessUserRepository;
import com.pitchIT.PitchUserService.repositories.InvestmentHistoryRepository;
import com.pitchIT.PitchUserService.repositories.InvestorUserRepository;
import com.pitchIT.PitchUserService.requests.ProfileRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    BusinessUserRepository businessUserRepository;
    InvestorUserRepository investorUserRepository;
    InvestmentHistoryRepository investmentHistoryRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (businessUserRepository.findByEmail(email).isPresent()){
            return businessUserRepository.findByEmail(email).get();
        }
        else {return investorUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Business email not found"));}
    }


    public PitchBusinessUser registerBusinessUserByEmail(PitchBusinessUser pitchBusinessUser){
        this.checkUser(pitchBusinessUser.getEmail());

        System.out.println(businessUserRepository.save(pitchBusinessUser));
        return pitchBusinessUser;
    }

    public PitchInvestorUser registerInvestorUserByEmail(PitchInvestorUser investorUser) {
        this.checkUser(investorUser.getEmail());

        InvestmentHistory investmentHistory = new InvestmentHistory(
                investorUser
        );
        investorUser.setInvestmentHistory(investmentHistory);
        investmentHistory.setPitchInvestorUser(investorUser);
        investmentHistoryRepository.save(investmentHistory);
        return investorUserRepository.save(investorUser);
    }

    private void checkUser(String email) {
        if (investorUserRepository.findByEmail(email).isPresent() || businessUserRepository.findByEmail(email).isPresent()){
            throw new IllegalStateException("User already Registered");
        }
    }

    public Optional getUser(String email){
        if (investorUserRepository.findByEmail(email).isPresent()){
            return investorUserRepository.findByEmail(email);
        }else if (businessUserRepository.findByEmail(email).isPresent()){
            return businessUserRepository.findByEmail(email);
        }else {
            throw new UsernameNotFoundException("Email not a business or investor");
        }
    }

    public PitchInvestorUser addToInvestmentHistoryByUser(String email, Map<String,String> investment) {
        PitchInvestorUser investorUser = investorUserRepository.findByEmail(email).get();
        System.out.println("INVESTMENT HISTORY:   "+investorUser);
        InvestmentHistory investmentHistory = investorUser.getInvestmentHistory();
        investmentHistory.addToInvestmentHistory(investment);
        investmentHistoryRepository.save(investmentHistory);
        System.out.println("InvestorUser:   "+investorUser.getInvestmentHistory());
        return investorUserRepository.save(investorUser);
    }

    public PitchInvestorUser updateAbout(String email,String about) {
        PitchInvestorUser investorUser = investorUserRepository.findByEmail(email).get();
        investorUser.setAbout(about);
        return investorUserRepository.save(investorUser);
    }

    public void updatePaid(String email) {
        if (businessUserRepository.findByEmail(email).isPresent()){
            System.out.println(businessUserRepository.findByEmail(email).isPresent());
            businessUserRepository.findByEmail(email).get().setPaid(true);
        }else if(investorUserRepository.findByEmail(email).isPresent()){
            System.out.println(investorUserRepository.findByEmail(email).isPresent());
            investorUserRepository.findByEmail(email).get().setPaid(true);
        }
        else throw new UsernameNotFoundException("User not found");
    }


    public Object editUserProfile(ProfileRequest profileRequest, String email) {
        if (investorUserRepository.findByEmail(email).isPresent()){
            PitchInvestorUser pitchInvestorUser = investorUserRepository.findByEmail(email).get();
            if (profileRequest.pictureUrl() != null){
                pitchInvestorUser.setPictureUrl(profileRequest.pictureUrl());
            }
            if (profileRequest.about() != null){
                pitchInvestorUser.setAbout(profileRequest.about());
            }
            return pitchInvestorUser;
        }else {
            PitchBusinessUser pitchBusinessUser = businessUserRepository.findByEmail(email).get();
            if (profileRequest.pictureUrl() != null){
                pitchBusinessUser.setPictureUrl(profileRequest.pictureUrl());
            }
            if (profileRequest.about() != null){
                pitchBusinessUser.setAbout(profileRequest.about());
            }
            return pitchBusinessUser;
        }

    }
}
