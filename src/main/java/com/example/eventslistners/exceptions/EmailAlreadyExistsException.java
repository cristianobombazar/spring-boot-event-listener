package com.example.eventslistners.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("The email "+email+" it's already being used");
    }
}
