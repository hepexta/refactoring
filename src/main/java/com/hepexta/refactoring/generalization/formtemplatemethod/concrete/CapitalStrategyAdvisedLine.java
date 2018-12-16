package com.hepexta.refactoring.generalization.formtemplatemethod.concrete;

import com.hepexta.refactoring.generalization.formtemplatemethod.CapitalStrategy;
import com.hepexta.refactoring.generalization.formtemplatemethod.Loan;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() *
                duration(loan) * riskFactorFor(loan);
    }

    private double riskFactorFor(Loan loan) {
        return loan.getRiskFactor();
    }

    private double duration(Loan loan) {
        return loan.getDuration();
    }
}
