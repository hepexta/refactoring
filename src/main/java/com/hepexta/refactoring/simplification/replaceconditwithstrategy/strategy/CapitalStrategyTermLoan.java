package com.hepexta.refactoring.simplification.replaceconditwithstrategy.strategy;

import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Loan;
import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Payment;

import java.util.Iterator;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    public double capital(Loan loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return loan.getCommitment() * duration(loan) * loan.riskFactor();
        else {
            return 0.;
        }
    }

    @Override
    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }

    private double weightedAverageDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = loan.getPayments().iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date(), loan) * payment.amount();
        }
        if (loan.getCommitment() != 0.0)
            duration = weightedAverage / sumOfPayments;
        return duration;
    }
}
