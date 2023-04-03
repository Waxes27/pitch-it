package com.pitchIT.PitchService.controllers;


import com.pitchIT.PitchService.models.*;
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
    public ResponseEntity createUserPitch(@RequestBody PitchDetailsRequest pitchDetailsRequest, @RequestParam String userId){


//        pitchTemplate.setTitle("PitchIT");

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
        service.getPitchByUsername("waxes27");
        return new ResponseEntity("Error Getting Pitches", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
