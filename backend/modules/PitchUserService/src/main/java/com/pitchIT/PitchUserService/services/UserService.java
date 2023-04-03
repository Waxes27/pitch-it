package com.pitchIT.PitchUserService.services;


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
        System.out.println(businessUserRepository.findByEmail(email));
        return businessUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Business email not found"));
    }


    public PitchBusinessUser registerBusinessUserByEmail(PitchBusinessUser pitchBusinessUser){
        System.out.println(businessUserRepository.save(pitchBusinessUser));
        return pitchBusinessUser;
    }

    public PitchInvestorUser registerInvestorUserByEmail(PitchInvestorUser investorUser) {
        System.out.println(investorUserRepository.save(investorUser));
        return investorUser;
    }
}
