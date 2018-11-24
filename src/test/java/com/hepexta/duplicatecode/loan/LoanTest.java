package com.hepexta.duplicatecode.loan;

import com.hepexta.duplicatecode.loan.strategy.CapitalStrategy;
import com.hepexta.duplicatecode.loan.strategy.RevolvingTermROC;
import com.hepexta.duplicatecode.loan.strategy.TermROC;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LoanTest {

    private final static float NOTIONAL = 1f;
    private final static float OUTSTANDING = 2f;
    private final static int RATING = 0;
    private final static Date EXPIRY = new Date();
    private final static Date MATURITY = new Date();

    @Test
    public void whenLoanConstructorNoMaturity_thanStrategyTermROC() {
        Loan loan = new Loan(NOTIONAL, OUTSTANDING, RATING, EXPIRY);
        Assert.assertEquals(NOTIONAL, loan.getNotional(), 0);
        Assert.assertEquals(OUTSTANDING, loan.getOutstanding(), 0);
        Assert.assertEquals(RATING, loan.getRating());
        Assert.assertEquals(EXPIRY, loan.getExpiry());
        Assert.assertEquals(TermROC.class.getName(), loan.getStrategy().getClass().getName());
        Assert.assertNull(loan.getMaturity());
    }

    @Test
    public void whenLoanConstructorWithMaturity_thanStrategyRevolvingTermROC() {
        Loan loan = new Loan(NOTIONAL, OUTSTANDING, RATING, EXPIRY, MATURITY);
        Assert.assertEquals(NOTIONAL, loan.getNotional(), 0);
        Assert.assertEquals(OUTSTANDING, loan.getOutstanding(), 0);
        Assert.assertEquals(RATING, loan.getRating());
        Assert.assertEquals(EXPIRY, loan.getExpiry());
        Assert.assertEquals(MATURITY, loan.getMaturity());
        Assert.assertEquals(RevolvingTermROC.class.getName(), loan.getStrategy().getClass().getName());
    }

    @Test
    public void whenLoanConstructorWithStrategy_thanStrategySpecified() {
        Loan loan = new Loan(new CapitalStrategy(), NOTIONAL, OUTSTANDING, RATING, EXPIRY, MATURITY);
        Assert.assertEquals(NOTIONAL, loan.getNotional(), 0);
        Assert.assertEquals(OUTSTANDING, loan.getOutstanding(), 0);
        Assert.assertEquals(RATING, loan.getRating());
        Assert.assertEquals(EXPIRY, loan.getExpiry());
        Assert.assertEquals(MATURITY, loan.getMaturity());
        Assert.assertEquals(CapitalStrategy.class.getName(), loan.getStrategy().getClass().getName());
    }
}