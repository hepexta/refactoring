package com.hepexta.refactoring.generalization.formtemplatemethod.concrete;

import com.hepexta.refactoring.generalization.formtemplatemethod.CapitalStrategy;
import com.hepexta.refactoring.generalization.formtemplatemethod.Loan;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    public double amountForLoan(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage();
    }

    public double riskFactorFor(Loan loan) {
        return loan.getRiskFactor();
    }

    public double duration(Loan loan) {
        return loan.getDuration();
    }
}
