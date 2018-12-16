package com.hepexta.refactoring.generalization.formtemplatemethod;

import com.hepexta.refactoring.generalization.formtemplatemethod.concrete.CapitalStrategyAdvisedLine;
import com.hepexta.refactoring.generalization.formtemplatemethod.concrete.CapitalStrategyRevolver;
import com.hepexta.refactoring.generalization.formtemplatemethod.concrete.CapitalStrategyTermLoan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CapitalStrategyTest {

    private Loan loan;

    @Before
    public void setUp() {
        loan = new Loan();
        loan.setAverageDuration(180);
        loan.setCommitment(1000);
        loan.setDuration(360);
        loan.setOutstandingRiskAmount(1);
        loan.setRiskFactor(2);
        loan.setUnusedPercentage(0.1);
        loan.setUnusedRiskFactor(0.2);
    }

    @Test
    public void testCapitalStrategyAdvisedLine() {
        CapitalStrategy strategy = new CapitalStrategyAdvisedLine();
        Assert.assertEquals(72000, strategy.capital(loan), 0);
    }

    @Test
    public void testCapitalStrategyRevolver() {
        CapitalStrategy strategy = new CapitalStrategyRevolver();
        Assert.assertEquals(15120, strategy.capital(loan), 0);
    }

    @Test
    public void testCapitalStrategyTermLoan() {
        CapitalStrategy strategy = new CapitalStrategyTermLoan();
        Assert.assertEquals(360000, strategy.capital(loan), 0);
    }

}
