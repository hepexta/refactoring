package com.hepexta.refactoring.simplification.replaceconditwithstrategy.strategy;

import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Loan;
import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Payment;

import java.util.Date;
import java.util.Iterator;

public class CapitalStrategy {

    private static final long MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;
    private Date today = null;

    public double capital(Loan loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return loan.getCommitment() * duration(loan) * loan.riskFactor();
        if (loan.getExpiry() != null && loan.getMaturity() == null) {
            if (loan.getUnusedPercentage() != 1.0)
                return loan.getCommitment() * loan.getUnusedPercentage() * duration(loan) * loan.riskFactor();
            else
                return (loan.outstandingRiskAmount() * duration(loan) * loan.riskFactor())
                        + (loan.unusedRiskAmount() * duration(loan) * loan.unusedRiskFactor());
        }
        return 0.0;
    }

    public double duration(Loan loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return weightedAverageDuration(loan);
        else if (loan.getExpiry() != null && loan.getMaturity() == null)
            return yearsTo(loan.getExpiry(), loan);
        return 0.0;
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

    private double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (today == null ? loan.getStart() : today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}
