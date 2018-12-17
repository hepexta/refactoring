package com.hepexta.refactoring.simplification.replaceconditwithstrategy;

import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class LoanTest {

    private static final double LOAN_AMOUNT = 70;
    private static final double HIGH_RISK_RATING = 1;
    private static final double TWO_DIGIT_PRECISION = 2;

    public Date november(int day, int year){
        return new Date(year-1900, 10, day);
    }

    @Test
    public void testTermLoanSamePayments() {
        Date start = november(20, 2003);
        Date maturity = november(20, 2006);
        Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, HIGH_RISK_RATING);
        termLoan.payment(1000.00, november(20, 2004));
        termLoan.payment(1000.00, november(20, 2005));
        termLoan.payment(1000.00, november(20, 2006));
        assertEquals("duration", 2.0, termLoan.duration(), TWO_DIGIT_PRECISION);
        assertEquals("capital", 280.00, termLoan.capital(), TWO_DIGIT_PRECISION);
    }

    @Test
    public void testRevolverSamePayments() {
        Date start = november(20, 2003);
        Date exparity = november(20, 2006);
        Loan termLoan = Loan.newRevolver(LOAN_AMOUNT, start, exparity, HIGH_RISK_RATING);
        termLoan.payment(1000.00, november(20, 2004));
        termLoan.payment(1000.00, november(20, 2005));
        termLoan.payment(1000.00, november(20, 2006));
        assertEquals("duration", 2.0, termLoan.duration(), TWO_DIGIT_PRECISION);
        assertEquals("capital", 1680.00, termLoan.capital(), TWO_DIGIT_PRECISION);
    }
}
