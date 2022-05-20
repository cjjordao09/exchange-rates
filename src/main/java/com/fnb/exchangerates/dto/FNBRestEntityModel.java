package com.fnb.exchangerates.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;


public abstract class FNBRestEntityModel implements IFNBRestEnity {

    public static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy  HH:mm:ss";

    protected  String result;

    protected  String provider;

    @JsonFormat(pattern = DATE_TIME_PATTERN, shape =  JsonFormat.Shape.STRING)
    protected LocalDateTime dateTime;


    @Override
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
