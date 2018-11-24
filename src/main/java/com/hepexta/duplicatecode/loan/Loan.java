package com.hepexta.duplicatecode.loan;

import com.hepexta.duplicatecode.loan.strategy.LoanStrategy;
import com.hepexta.duplicatecode.loan.strategy.RevolvingTermROC;
import com.hepexta.duplicatecode.loan.strategy.TermROC;

import java.util.Date;

public class Loan {

    private final LoanStrategy strategy;
    private final float notional;
    private final float outstanding;
    private final int rating;
    private final Date expiry;
    private Date maturity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this(new TermROC(), notional, outstanding, rating, expiry, null);
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this(new RevolvingTermROC(), notional, outstanding, rating, expiry, maturity);
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
