package com.fnb.exchangerates.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyRate {

    private @Id @GeneratedValue Long id;
    private String currency;
    private double purchase;
    private double sale;


    public CurrencyRate() {
    }

    public CurrencyRate(String currency, double purchase, double sale) {
        this.currency = currency;
        this.purchase = purchase;
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }
}
