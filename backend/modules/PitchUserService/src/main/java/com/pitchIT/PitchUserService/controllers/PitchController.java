package com.pitchIT.PitchUserService.controllers;


import com.pitchIT.PitchUserService.requests.PitchDetailsRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pitch")
@AllArgsConstructor
public class PitchController {

    private final RestTemplate restTemplate;


    @PostMapping
    public String createPitch(@RequestBody PitchDetailsRequest pitchDetailsRequest, @RequestParam String userId){
        restTemplate.postForEntity(
                "http://pitch-service:10001/api/pitch?userId="+userId,
                pitchDetailsRequest,
                ResponseEntity.class);

        return "";
    }
    
}
