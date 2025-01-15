package com.codewithjay.hotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
       super("Resource Not Found on the Server");
    }
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
