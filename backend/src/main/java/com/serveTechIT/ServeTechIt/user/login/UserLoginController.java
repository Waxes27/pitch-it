package com.serveTechIT.ServeTechIt.user.login;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @PostMapping
    public String login(){
        return "";
    }

    @GetMapping
    public String noPage(){
        return "Please login";
    }
}
