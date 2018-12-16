package com.hepexta.refactoring.generalization.formtemplatemethod.concrete;

import com.hepexta.refactoring.generalization.formtemplatemethod.CapitalStrategy;
import com.hepexta.refactoring.generalization.formtemplatemethod.Loan;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    public double amountForLoan(Loan loan) {
        return loan.getCommitment();
    }

    public double riskFactorFor(Loan loan) {
        return loan.getRiskFactor();
    }

    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }
    private double weightedAverageDuration(Loan loan){
        return loan.getAverageDuration();
    }
}
