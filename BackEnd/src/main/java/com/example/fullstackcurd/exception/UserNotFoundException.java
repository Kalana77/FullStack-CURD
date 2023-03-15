package com.example.fullstackcurd.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int id) {
        super("could not found the user with id "+ id);
    }
}
