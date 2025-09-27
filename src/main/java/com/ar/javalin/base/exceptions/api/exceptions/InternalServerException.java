package com.ar.javalin.base.exceptions.api.exceptions;

public class InternalServerException extends RuntimeException{
    public InternalServerException(Exception e) {
        super("Internal server error: "+e.getMessage());
    }    
}
