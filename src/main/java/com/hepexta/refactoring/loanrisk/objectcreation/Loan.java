package com.hepexta.refactoring.loanrisk.objectcreation;

import com.hepexta.refactoring.loanrisk.objectcreation.strategy.LoanStrategy;
import com.hepexta.refactoring.loanrisk.objectcreation.strategy.RevolvingTermROC;
import com.hepexta.refactoring.loanrisk.objectcreation.strategy.TermROC;

import java.util.Date;

/*
* Loan could be used to represent three kinds of loans:
* - A term loan is a loan that must be fully paid by its maturity date.
* - A revolver, which is like a credit card, is a loan that signifies “revolving credit”:
* you have a spending limit and an expiry date.
* */
public class Loan {

    private final LoanStrategy strategy;
    private final float notional;
    private final float outstanding;
    private final int rating;
    private final Date expiry;
    private Date maturity;

    public static Loan createTermLoan(float notional, float outstanding, int rating, Date expiry) {
        return new Loan(new TermROC(), notional, outstanding, rating, expiry, null);
    }

    public static Loan createRevolvingTermLoan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        return new Loan(new RevolvingTermROC(), notional, outstanding, rating, expiry, maturity);
    }

    public Loan(LoanStrategy strategy, float notional, float outstanding,
                int rating, Date expiry, Date maturity) {
        this.strategy = strategy;
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public LoanStrategy getStrategy() {
        return strategy;
    }

    public float getNotional() {
        return notional;
    }

    public float getOutstanding() {
        return outstanding;
    }

    public int getRating() {
        return rating;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }
}
