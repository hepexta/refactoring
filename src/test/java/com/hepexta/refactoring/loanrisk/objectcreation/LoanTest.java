package com.hepexta.refactoring.loanrisk.objectcreation;

import com.hepexta.refactoring.loanrisk.objectcreation.strategy.CapitalStrategy;
import com.hepexta.refactoring.loanrisk.objectcreation.strategy.RevolvingTermROC;
import com.hepexta.refactoring.loanrisk.objectcreation.strategy.TermROC;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/*
* Tests represents client side
* */
public class LoanTest {

    private final static float NOTIONAL = 1f;
    private final static float OUTSTANDING = 2f;
    private final static int RATING = 0;
    private final static Date EXPIRY = new Date();
    private final static Date MATURITY = new Date();

    @Test
    public void whenLoanConstructorNoMaturity_thanStrategyTermROC() {
        Loan loan = Loan.createTermLoan(NOTIONAL, OUTSTANDING, RATING, EXPIRY);
        Assert.assertEquals(NOTIONAL, loan.getNotional(), 0);
        Assert.assertEquals(OUTSTANDING, loan.getOutstanding(), 0);
        Assert.assertEquals(RATING, loan.getRating());
        Assert.assertEquals(EXPIRY, loan.getExpiry());
        Assert.assertEquals(TermROC.class.getName(), loan.getStrategy().getClass().getName());
        Assert.assertNull(loan.getMaturity());
    }

    @Test
    public void whenLoanConstructorWithMaturity_thanStrategyRevolvingTermROC() {
        Loan loan = Loan.createRevolvingTermLoan(NOTIONAL, OUTSTANDING, RATING, EXPIRY, MATURITY);
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