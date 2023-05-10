package com.pitchIT.PitchUserService.controllers;

//import org.json.JSONObject;
import com.google.firebase.auth.FirebaseAuthException;
import com.pitchIT.PitchUserService.enums.UserRoles;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.models.auth.ChatAuthResponse;
import com.pitchIT.PitchUserService.requests.BusinessRegisterRequest;
import com.pitchIT.PitchUserService.requests.InvestmentHistoryRequest;
import com.pitchIT.PitchUserService.requests.InvestorRegisterRequest;
import com.pitchIT.PitchUserService.security.PasswordEncoder;
import com.pitchIT.PitchUserService.services.UserService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class LoginController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    private final RestTemplate restTemplate;


    @PostMapping(path = "/login")
    public Object login(
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

            return authentication.getPrincipal();

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(path = "/register/business")
    public PitchBusinessUser registerBusiness(@RequestBody BusinessRegisterRequest registerRequest) throws FirebaseAuthException {
        PitchBusinessUser businessUser = new PitchBusinessUser(
                registerRequest.businessName(),
                registerRequest.representativeFirstName(),
                registerRequest.representativeLastName(),
                UserRoles.BUSINESS,
                registerRequest.email(),
                passwordEncoder.bCryptPasswordEncoder().encode(registerRequest.password())
        );
        businessUser = userService.registerBusinessUserByEmail(businessUser);



        return businessUser;
    }

    @PostMapping(path = "/register/investor")
    public PitchInvestorUser registerInvestor(@RequestBody InvestorRegisterRequest registerRequest) throws FirebaseAuthException {
        System.out.println(registerRequest);

        PitchInvestorUser investorUser = new PitchInvestorUser(
                registerRequest.firstName(),
                registerRequest.lastName(),
                UserRoles.INVESTOR,
                registerRequest.email(),
                passwordEncoder.bCryptPasswordEncoder().encode(registerRequest.password())
        );
        investorUser = userService.registerInvestorUserByEmail(investorUser);

        JSONObject map = new JSONObject();
        map.put("name",registerRequest.firstName());
        map.put("username", registerRequest.email().replace("@gmail.com",""));
        map.put("email",registerRequest.email());
        map.put("password",registerRequest.password());
        map.put("profilePicUrl","profilePicLinkHere");
        System.out.println(map);

//        ResponseEntity<Map> response = restTemplate.postForEntity(
//                "http://pitchIt-chat:8017/users",
//                map,
//                Map.class
//        );

        return investorUser;
    }
    @GetMapping("/user/{email}")
    public Object getUserByEmail(@PathVariable String email){
        return userService.getUser(email).get();
    }

    @PostMapping("/about/{email}")
    public Object updateAbout(@PathVariable String email, @RequestBody Map about){
        return userService.updateAbout(email,about.get("about").toString());
    }

    @PostMapping("/{email}/")
    public PitchInvestorUser postInvestmentHistory(@RequestBody InvestmentHistoryRequest investmentHistoryRequest, @PathVariable String email){
        Map<String,String> investment = new HashMap<>();

        investment.put("company",investmentHistoryRequest.company());
        investment.put("link",investmentHistoryRequest.link());
        investment.put("description",investmentHistoryRequest.description());
        investment.put("fromYear", investmentHistoryRequest.fromYear());
        investment.put("toYear",investmentHistoryRequest.toYear());


        return userService.addToInvestmentHistoryByUser(email,investment);
    }



}