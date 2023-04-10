package com.pitchIT.PitchUserService.controllers;


import com.pitchIT.PitchUserService.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/paid/{email}")
    public void editUserPaid(@PathVariable String email){
        userService.updatePaid(email);
    }
}
