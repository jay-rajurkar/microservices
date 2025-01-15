package com.jayrajurkar.microservices.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    //extra properties you need to manage
    public ResourceNotFoundException(){
        super("Resource Not Found on Server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
