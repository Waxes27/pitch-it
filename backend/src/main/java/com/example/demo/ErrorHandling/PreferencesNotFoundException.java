package com.example.demo.ErrorHandling;

public class PreferencesNotFoundException extends RuntimeException {
    
    public PreferencesNotFoundException(Long id) {
        super("Could not find preferences for business " + id);
    }
}
