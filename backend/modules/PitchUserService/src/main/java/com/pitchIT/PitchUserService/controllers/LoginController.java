package com.pitchIT.PitchUserService.controllers;

//import org.json.JSONObject;
import com.pitchIT.PitchUserService.enums.UserRoles;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.requests.BusinessRegisterRequest;
import com.pitchIT.PitchUserService.requests.InvestorRegisterRequest;
import com.pitchIT.PitchUserService.security.PasswordEncoder;
import com.pitchIT.PitchUserService.services.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    PasswordEncoder passwordEncoder = new PasswordEncoder();

    @PostMapping(path = "/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        JSONObject jsonObject = new JSONObject();
        System.out.println(username +" : "+password);


        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,password));
            System.out.println(authentication.isAuthenticated());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Logging in");

            return authentication.getPrincipal().toString();

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(path = "/register/business")
    public String registerBusiness(@RequestBody BusinessRegisterRequest registerRequest){
        System.out.println(registerRequest);

        PitchBusinessUser businessUser = new PitchBusinessUser(
                registerRequest.businessName(),
                registerRequest.representativeFirstName(),
                registerRequest.representativeLastName(),
                UserRoles.BUSINESS,
                registerRequest.email(),
                passwordEncoder.bCryptPasswordEncoder().encode(registerRequest.password())
        );
        userService.registerBusinessUserByEmail(businessUser);

        return businessUser.toString();
    }

    @PostMapping(path = "/register/investor")
    public String registerInvestor(@RequestBody InvestorRegisterRequest registerRequest){
        System.out.println(registerRequest);

        PitchInvestorUser investorUser = new PitchInvestorUser(
                registerRequest.firstName(),
                registerRequest.lastName(),
                UserRoles.INVESTOR,
                registerRequest.email(),
                passwordEncoder.bCryptPasswordEncoder().encode(registerRequest.password())
        );
        userService.registerInvestorUserByEmail(investorUser);


        return investorUser.toString();
    }
}