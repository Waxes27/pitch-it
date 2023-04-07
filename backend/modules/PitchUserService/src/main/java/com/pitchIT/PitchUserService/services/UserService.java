package com.pitchIT.PitchUserService.services;


import com.pitchIT.PitchUserService.models.InvestmentHistory;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.repositories.BusinessUserRepository;
import com.pitchIT.PitchUserService.repositories.InvestorUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    BusinessUserRepository businessUserRepository;
    InvestorUserRepository investorUserRepository;


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
        InvestmentHistory investmentHistory = new InvestmentHistory();
        investmentHistory.setPitchInvestorUser(investorUser);
        investorUser.setInvestmentHistory(investmentHistory);
        investorUserRepository.save(investorUser);
        return investorUser;
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
}
