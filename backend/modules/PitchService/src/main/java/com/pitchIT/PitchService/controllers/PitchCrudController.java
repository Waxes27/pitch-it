package com.pitchIT.PitchService.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pitch")
public class PitchCrudController {

    @GetMapping
    public void getUserPitch(){

    }
}
