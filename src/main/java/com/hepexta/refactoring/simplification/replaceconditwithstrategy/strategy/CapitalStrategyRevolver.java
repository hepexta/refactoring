package com.hepexta.refactoring.simplification.replaceconditwithstrategy.strategy;

import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Loan;

public class CapitalStrategyRevolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        if (loan.getUnusedPercentage() != 1.0)
            return loan.getCommitment() * loan.getUnusedPercentage() * duration(loan) * loan.riskFactor();
        else
            return (loan.outstandingRiskAmount() * duration(loan) * loan.riskFactor())
                    + (loan.unusedRiskAmount() * duration(loan) * loan.unusedRiskFactor());
    }

    @Override
    public double duration(Loan loan) {
        return yearsTo(loan.getExpiry(), loan);
    }
}
