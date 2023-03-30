package com.pitchIT.PitchService.controllers;


import com.pitchIT.PitchService.requests.PitchDetailsRequest;
import com.pitchIT.PitchService.services.PitchCrudService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/pitch")
@AllArgsConstructor
public class PitchCrudController {

    private final PitchCrudService service;

    @PostMapping
    public ResponseEntity createUserPitch(@RequestBody PitchDetailsRequest pitchDetailsRequest){

        service.savePitch(
                pitchDetailsRequest.businessDetails(),
                pitchDetailsRequest.companyDetails(),
                pitchDetailsRequest.documents(),
                pitchDetailsRequest.marketDetails(),
                pitchDetailsRequest.memberDetails()
        );

        return new ResponseEntity("Error Creating Pitch", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    public ResponseEntity getUserPitch(){

        return new ResponseEntity("Error Getting Pitches", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}