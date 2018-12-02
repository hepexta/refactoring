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
* - A revolving credit term loan (RCTL) is a revolver that transforms into a term loan when the revolver expires.
* */
public class Loan {

    private final LoanStrategy strategy;
    private final float notional;
    private final float outstanding;
    private final int rating;
    private final Date expiry;
    private Date maturity;

    /**
     * Term loan constructor
     * */
    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this(new TermROC(), notional, outstanding, rating, expiry, null);
    }

    /**
     * Revolving Credit constructor
     * */
    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this(new RevolvingTermROC(), notional, outstanding, rating, expiry, maturity);
    }

    /**
     * Revolving Credit Term Loan constructor
     * */
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
