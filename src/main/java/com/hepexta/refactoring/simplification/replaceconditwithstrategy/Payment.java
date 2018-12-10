package com.hepexta.refactoring.simplification.replaceconditwithstrategy;

import java.util.Date;

public class Payment {

    private double amount;
    private Date date;

    private Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public static Payment payment(double amount, Date date) {
        return new Payment(amount, date);
    }

    public double amount() {
        return amount;
    }

    public Date date() {
        return date;
    }
}
