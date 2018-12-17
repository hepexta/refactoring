package com.hepexta.refactoring.generalization.formtemplatemethod;

public abstract class CapitalStrategy {
    public double capital(Loan loan){
        return amountForLoan(loan) * duration(loan) * riskFactorFor(loan);
    }

    public abstract double amountForLoan(Loan loan);

    public abstract double riskFactorFor(Loan loan);

    public abstract double duration(Loan loan);
}
