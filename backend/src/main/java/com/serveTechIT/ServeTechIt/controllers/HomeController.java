package com.serveTechIT.ServeTechIt.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping
    public HashMap homepage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        HashMap<String,String> creds = new HashMap<>();
        creds.put("principal",authentication.getPrincipal().toString());
        creds.put("authenticated", String.valueOf(authentication.isAuthenticated()));
        creds.put("authority",authentication.getAuthorities().toString());
        return creds;
    }
}
