package com.pitchIt.pitchIt.exceptions;

public class BusinessNotFoundException extends RuntimeException {

    private final  String message;
    public BusinessNotFoundException(String message) {
        super(message);
        this.message = message;

    }
}
