package com.pitchIT.PitchService.controllers;


import com.pitchIT.PitchService.models.*;
import com.pitchIT.PitchService.requests.PitchDetailsRequest;
import com.pitchIT.PitchService.services.PitchCrudService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/pitch")
@AllArgsConstructor
public class PitchCrudController {

    private final PitchCrudService service;

    @PostMapping
    public ResponseEntity createUserPitch(@RequestBody PitchDetailsRequest pitchDetailsRequest, @RequestParam String userId){

        Pitch pitch = service.savePitch(
                userId,
                pitchDetailsRequest.businessDetails(),
                pitchDetailsRequest.companyDetails(),
                pitchDetailsRequest.documents(),
                pitchDetailsRequest.marketDetails(),
                pitchDetailsRequest.memberDetails()
        );

        return new ResponseEntity(pitch, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getUserPitch(){
        List<Optional<Pitch>> pitches = service.getAllPitchByUsername("waxes27");
        return new ResponseEntity(pitches, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Pitch> getAll(){
        return service.getAllPitches();
    }


}
