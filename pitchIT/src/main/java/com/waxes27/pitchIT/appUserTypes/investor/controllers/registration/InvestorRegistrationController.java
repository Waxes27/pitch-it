package com.waxes27.pitchIT.appUserTypes.investor.controllers.registration;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register/investor")
public class InvestorRegistrationController {
    @PostMapping
    public void registerInvestor(){

    }
}
