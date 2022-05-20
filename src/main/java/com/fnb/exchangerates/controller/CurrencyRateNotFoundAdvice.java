package com.fnb.exchangerates.controller;

import com.fnb.exchangerates.exception.RateNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CurrencyRateNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String rateNotFoundHandler(RateNotFoundException exception){
        return exception.getMessage();
    }
}
