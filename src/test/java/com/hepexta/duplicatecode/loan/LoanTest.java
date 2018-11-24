package com.hepexta.duplicatecode.loan;

import com.hepexta.duplicatecode.loan.strategy.CapitalStrategy;
import com.hepexta.duplicatecode.loan.strategy.RevolvingTermROC;
import com.hepexta.duplicatecode.loan.strategy.TermROC;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LoanTest {

    private final float notional = 1f;
    private final float outstanding = 2f;
    private final int rating  = 0;
    private final Date expiry = new Date();
    private Date maturity = new Date();

    @Test
    public void whenLoanConstructorNoMaturity_thanStrategyTermROC() {
        Loan loan = new Loan(notional, outstanding, rating, expiry);
        Assert.assertEquals(notional, loan.getNotional(), 0);
        Assert.assertEquals(outstanding, loan.getOutstanding(), 0);
        Assert.assertEquals(rating, loan.getRating());
        Assert.assertEquals(expiry, loan.getExpiry());
        Assert.assertEquals(TermROC.class.getName(), loan.getStrategy().getClass().getName());
        Assert.assertNull(loan.getMaturity());
    }

    @Test
    public void whenLoanConstructorWithMaturity_thanStrategyRevolvingTermROC() {
        Loan loan = new Loan(notional, outstanding, rating, expiry, maturity);
        Assert.assertEquals(notional, loan.getNotional(), 0);
        Assert.assertEquals(outstanding, loan.getOutstanding(), 0);
        Assert.assertEquals(rating, loan.getRating());
        Assert.assertEquals(expiry, loan.getExpiry());
        Assert.assertEquals(maturity, loan.getMaturity());
        Assert.assertEquals(RevolvingTermROC.class.getName(), loan.getStrategy().getClass().getName());
    }

    @Test
    public void whenLoanConstructorWithStrategy_thanStrategySpecified() {
        Loan loan = new Loan(new CapitalStrategy(), notional, outstanding, rating, expiry, maturity);
        Assert.assertEquals(notional, loan.getNotional(), 0);
        Assert.assertEquals(outstanding, loan.getOutstanding(), 0);
        Assert.assertEquals(rating, loan.getRating());
        Assert.assertEquals(expiry, loan.getExpiry());
        Assert.assertEquals(maturity, loan.getMaturity());
        Assert.assertEquals(CapitalStrategy.class.getName(), loan.getStrategy().getClass().getName());
    }
}