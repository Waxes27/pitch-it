package com.pitchIT.PitchUserService.services;


import com.pitchIT.PitchUserService.models.InvestmentHistory;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.repositories.BusinessUserRepository;
import com.pitchIT.PitchUserService.repositories.InvestmentHistoryRepository;
import com.pitchIT.PitchUserService.repositories.InvestorUserRepository;
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
        System.out.println(businessUserRepository.save(pitchBusinessUser));
        return pitchBusinessUser;
    }

    public PitchInvestorUser registerInvestorUserByEmail(PitchInvestorUser investorUser) {
        InvestmentHistory investmentHistory = new InvestmentHistory(
                investorUser
        );
        Map investments = new HashMap();

        investorUser.setInvestmentHistory(investmentHistory);
        investmentHistory.setPitchInvestorUser(investorUser);
//        investments.setInvestmentHistory(investmentHistory);

//        investmentsRepository.save(investments);
        investmentHistoryRepository.save(investmentHistory);
//        investorUserRepository.save(investorUser);
        return investorUserRepository.save(investorUser);
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
}
