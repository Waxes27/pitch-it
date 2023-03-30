package com.pitchIt.pitchIt.business.controllers;

import com.pitchIt.pitchIt.business.entities.Business;
import com.pitchIt.pitchIt.business.exceptions.BusinessNotFoundException;
import com.pitchIt.pitchIt.business.repositories.BusinessRepository;
import com.pitchIt.pitchIt.requests.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
// Add "/api" path here
public class BusinessController {
    private final BusinessRepository repository;

    public BusinessController(BusinessRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/sign-up")
    ResponseEntity signUp(@RequestBody Business business) {
        Business existingBusiness = repository.findByExisting(business.getEmail(), business.getName());
        if (existingBusiness == null) {
            return new ResponseEntity(repository.save(business), HttpStatus.CREATED);
        } else if (repository.findByEmail(business.getEmail()) != null){
            return new ResponseEntity(
                    "Business email: " + business.getEmail() + " already exists.", HttpStatus.CONFLICT);
        } else if (repository.findByBusinessName(business.getName()) != null) {
            return new ResponseEntity(
                    "Business name: " + business.getName() + " already exists.", HttpStatus.CONFLICT);
        }
        return new ResponseEntity("Error Registering new Business", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/sign-in")
    ResponseEntity signIn(@RequestBody LoginRequest request) {
        Business business = repository.findByEmail(request.email(), request.password());
        if (business != null) {
            return new ResponseEntity(business, HttpStatus.OK);
        } else {
            return new ResponseEntity(
                    new BusinessNotFoundException("Business data not found!").getMessage(),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
