package com.pitchIt.pitchIt.business.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exeption.message.businessNotFoundMessage}")
    private String businessNotFoundMessage;
    @Value(value = "${data.exeption.message.businessAlreadyExistsMessage}")
    private String businessAlreadyExistsMessage;

    @ExceptionHandler(value = BusinessNotFoundException.class)
    public ResponseEntity businessNotFoundException(BusinessNotFoundException businessNotFoundException) {
        return new ResponseEntity(businessNotFoundMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BusinessAlreadyExistsException.class)
    public ResponseEntity businessAlreadyExists(BusinessAlreadyExistsException businessAlreadyExistsException) {
        return new ResponseEntity(businessAlreadyExistsMessage, HttpStatus.CONFLICT);
    }
}
