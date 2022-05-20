package com.fnb.exchangerates.dto;

import com.google.gson.Gson;

import java.time.LocalDateTime;

public class MozDefaultCurrencyRate extends FNBRestEntityModel {

    private final String baseCurrency = "MZN";

    private CurrencyRateDTO[] rates;

    public MozDefaultCurrencyRate(String result, String provider, CurrencyRateDTO... rates) {
        this.result = result;
        this.provider = provider;
        this.dateTime = LocalDateTime.now();
        this.rates = rates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public CurrencyRateDTO[] getRates() {
        return rates;
    }

    public void setRates(CurrencyRateDTO... rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
