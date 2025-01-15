package com.codewithjay.rating.RatingMicroservice.exceptions;

public class ResousrceNotFoundException extends RuntimeException {

    public ResousrceNotFoundException(){
        super("Resource Not found at Server");
    }
    public ResousrceNotFoundException(String message) {
        super(message);
    }
}
