package com.pitchIt.pitchIt.preference.controllers;


import com.pitchIt.pitchIt.investor.entities.Investor;
import com.pitchIt.pitchIt.preference.entities.UserPreference;
import com.pitchIt.pitchIt.preference.repositories.UserPrefencesRepository;
import com.pitchIt.pitchIt.requests.UserPreferenceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/user")
public class UserPreferencesController {

    UserPrefencesRepository repository;

    public UserPreferencesController(UserPrefencesRepository repository) {
        this.repository = repository;
    }



    @RequestMapping("/sign-up/preference/{uid}")
    ResponseEntity createUserPreferences(@RequestBody UserPreferenceRequest request,
                                         @PathVariable("uid") String uid) {
        UserPreference preference = new UserPreference(
                Integer.valueOf(uid),
                request.industry(),
                request.location(),
                request.developmentStage(),
                request.customerGroup(),
                request.investmentStage(),
                request.seisPreference()
        );
        return new ResponseEntity(repository.save(preference), HttpStatus.CREATED);
    }

}
