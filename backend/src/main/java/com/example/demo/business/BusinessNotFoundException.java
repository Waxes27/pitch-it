package com.example.demo.business;


class BusinessNotFoundException extends RuntimeException {

    public BusinessNotFoundException(Long id) {
        super("Could not find business " + id);
    }

}
