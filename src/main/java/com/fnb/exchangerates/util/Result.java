package com.fnb.exchangerates.util;

public enum Result {
    SUCCESS("success"),
    ERROR("error"),
    WARNING("warning");

    public final String value;

    private Result(String value){
        this.value = value;
    }


}
