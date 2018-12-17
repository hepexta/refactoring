package com.hepexta.refactoring.generalization.formtemplatemethod.concrete;

import com.hepexta.refactoring.generalization.formtemplatemethod.CapitalStrategy;
import com.hepexta.refactoring.generalization.formtemplatemethod.Loan;

public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return super.capital(loan) + unusedCapitral(loan);
    }

    public double amountForLoan(Loan loan) {
        return loan.outstandingRiskAmount();
    }

    public double riskFactorFor(Loan loan) {
        return loan.getRiskFactor();
    }

    public double duration(Loan loan) {
        return loan.getDuration();
    }

    private double unusedCapitral(Loan loan) {
        return loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan);
    }

    private double unusedRiskFactor(Loan loan) {
        return loan.getUnusedRiskFactor();
    }
}
