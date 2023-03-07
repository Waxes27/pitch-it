package com.waxes27.pitchIT.appUserTypes.investor.Services;

import com.waxes27.pitchIT.appUserTypes.investor.repository.InvestorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class InvestorRegistrationService implements UserDetailsService {

    private final InvestorRepository investorRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
