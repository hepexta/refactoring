package com.hepexta.refactoring.generalization.formtemplatemethod.concrete;

import com.hepexta.refactoring.generalization.formtemplatemethod.CapitalStrategy;
import com.hepexta.refactoring.generalization.formtemplatemethod.Loan;

public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * duration(loan) * riskFactorFor(loan))
                + (loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan));
    }

    private double unusedRiskFactor(Loan loan) {
        return loan.getUnusedRiskFactor();
    }

    private double riskFactorFor(Loan loan) {
        return loan.getRiskFactor();
    }

    private double duration(Loan loan) {
        return loan.getDuration();
    }
}
