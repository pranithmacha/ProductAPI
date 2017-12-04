package com.retail.target.dto;

/**
 * Created by pranith macha on 12/4/17.
 */
public class PriceDTO {

    private double value;
    private String currencyCode;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
