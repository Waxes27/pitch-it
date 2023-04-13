package com.pitchIT.PitchUserService.controllers;


import com.pitchIT.PitchUserService.models.Pitch;
import com.pitchIT.PitchUserService.requests.PitchDetailsRequest;
import com.pitchIT.PitchUserService.services.UserService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/pitch")
@AllArgsConstructor
public class PitchController {

    private final RestTemplate restTemplate;
    private final UserService userService;


    @PostMapping
    public ResponseEntity<Pitch> createPitchByUserId(@RequestBody PitchDetailsRequest pitchDetailsRequest, @RequestParam String userId){

        return restTemplate.postForEntity(
                "http://pitch-service:10001/api/pitch?userId="+userId,
                pitchDetailsRequest,
                Pitch.class);
    }

    @GetMapping
    public ResponseEntity<List> getPitchesByUserId(@RequestParam String username){
        return restTemplate.getForEntity(
                "http://pitch-service:10001/api/pitch?username="+username,
                List.class);
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllPitches(){
        return restTemplate.getForEntity(
                "http://pitch-service:10001/api/pitch/all",
                List.class);
    }

    @GetMapping("id")
    public ResponseEntity<Pitch> getPitchById(@RequestParam String id){

        return restTemplate.getForEntity(
                "http://pitch-service:10001/api/pitch/id?id="+id,
                Pitch.class);
    }


}
