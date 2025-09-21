package com.ar.javalin.base.exceptions.api.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found exception");
    }
    
}
