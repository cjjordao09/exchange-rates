package com.fnb.exchangerates.exception;

public class RateNotFoundException extends RuntimeException {

    public RateNotFoundException(Long id){
        super("Could not find rate with ID: " + id);
    }

}
