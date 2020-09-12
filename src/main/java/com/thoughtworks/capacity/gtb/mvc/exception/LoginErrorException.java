package com.thoughtworks.capacity.gtb.mvc.exception;

public class LoginErrorException extends RuntimeException {

    public LoginErrorException(String message){
        super(message);
    }
}
