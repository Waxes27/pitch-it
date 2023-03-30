package com.pitchIt.pitchIt.business.exceptions;

public class BusinessAlreadyExistsException extends RuntimeException {
    private final String message;

    public BusinessAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
