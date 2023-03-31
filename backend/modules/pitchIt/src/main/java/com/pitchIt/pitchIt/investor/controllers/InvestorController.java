package com.pitchIt.pitchIt.investor.controllers;

import com.pitchIt.pitchIt.investor.entities.Investor;
import com.pitchIt.pitchIt.investor.repositories.InvestorRepository;
import com.pitchIt.pitchIt.requests.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investor")
public class InvestorController {
    private InvestorRepository repository;

    public InvestorController(InvestorRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sign-up")
    ResponseEntity signUp(@RequestBody Investor investor) {
        Investor existingInvestor = repository.findByEmail(investor.getEmail());
        if (existingInvestor == null) {
            return new ResponseEntity(repository.save(investor), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(
                    "Investor User with email: " + investor.getEmail() + " already exists.", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/sign-in")
    ResponseEntity signIn(@RequestBody LoginRequest loginRequest) {
        Investor investor = repository.signIn(loginRequest.email(), loginRequest.password());

        if (investor != null) {
            return new ResponseEntity(investor, HttpStatus.OK);
        } else {
            return new ResponseEntity(
                    "Investor user with email: " + loginRequest.email() + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
