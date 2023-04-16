package com.pitchIT.PitchUserService.controllers;

import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.requests.InvestmentHistoryRequest;
import com.pitchIT.PitchUserService.requests.ProfileRequest;
import com.pitchIT.PitchUserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController_CST {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Object postInvestmentHistory(@RequestBody ProfileRequest profileRequest, @RequestParam("email") String email){
        return userService.editUserProfile(profileRequest, email);
    }
}
