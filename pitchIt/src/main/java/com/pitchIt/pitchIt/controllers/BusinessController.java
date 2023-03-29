package com.pitchIt.pitchIt.controllers;

import com.pitchIt.pitchIt.entities.Business;
import com.pitchIt.pitchIt.exceptions.BusinessAlreadyExistsException;
import com.pitchIt.pitchIt.exceptions.BusinessNotFoundException;
import com.pitchIt.pitchIt.repositories.BusinessRepository;
import com.pitchIt.pitchIt.requests.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
// Add "/api" path here
public class BusinessController {
    private final BusinessRepository repository;


    public BusinessController(BusinessRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sign-up")
    Business createBusiness(@RequestBody Business business) {
        Business existingBusiness = repository.findByExisting(business.getEmail(), business.getName());
        if (existingBusiness == null) {
        return repository.save(business);
        } else if (repository.findByEmail(business.getEmail()) != null){
            throw new BusinessAlreadyExistsException(
                    "Business email: " + business.getEmail() + " already exists."
            );
        } else if (repository.findByBusinessName(business.getName()) != null) {
            throw new BusinessAlreadyExistsException(
                    "Business name: " + business.getName() + " already exists."
            );
        }
//        ADD: BUSINESS NAME/EMAIL ALREADY TAKEN
        return null;
    }

    @GetMapping("/sign-in")
    Business getBusiness(@RequestBody LoginRequest request) {
        Business business = repository.findByEmail(request.email(), request.password());
        if (business != null) {
            return  business;
        } else {
            throw new BusinessNotFoundException(
                    "Business data not found!"
            );
        }
//        ADD: Business NOT FOUND
//        return null;
    }
}
