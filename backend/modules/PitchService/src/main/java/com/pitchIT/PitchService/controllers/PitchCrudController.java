package com.pitchIT.PitchService.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pitch")
public class PitchCrudController {

    @PostMapping
    public ResponseEntity createUserPitch(){


        return new ResponseEntity("Error Creating Pitch", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    public ResponseEntity getUserPitch(){

        return new ResponseEntity("Error Getting Pitches", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
