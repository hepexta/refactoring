package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

public class Price {

    private String currency;
    private float price;

    public Price(String currency, float price) {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public float getPrice() {
        return price;
    }
}
