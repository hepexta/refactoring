package com.hepexta.refactoring.simplification.replaceconditwithstrategy;

import com.hepexta.refactoring.loanrisk.objectcreation.strategy.LoanStrategy;
import com.hepexta.refactoring.loanrisk.objectcreation.strategy.TermROC;

import java.util.*;

public class Loan {

    private static final long MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;
    private final double commitment;
    private final double outstanding;
    private final Date expiry = null;
    private final LoanStrategy strategy;
    private Date maturity;
    private List<Payment> payments = new ArrayList<>();
    private Date today = null;
    private Date start;
    private double riskRating;

    public Loan(LoanStrategy strategy, double commitment, Date start, Date maturity, double highRiskRating) {
        this.riskRating = highRiskRating;
        this.maturity = maturity;
        this.start = start;
        this.strategy = strategy;
        this.commitment = commitment;
        this.outstanding = 1;
    }

    public static Loan newTermLoan(double amount, Date start, Date maturity, double highRiskRating) {
        return new Loan(new TermROC(), amount, start, maturity, highRiskRating);
    }

    public double capital() {
        if (expiry == null && maturity != null)
            return commitment * duration() * riskFactor();
        if (expiry != null && maturity == null) {
            if (getUnusedPercentage() != 1.0)
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            else
                return (outstandingRiskAmount() * duration() * riskFactor())
                        + (unusedRiskAmount() * duration() * unusedRiskFactor());
        }
        return 0.0;
    }

    public double duration() {
        if (expiry == null && maturity != null)
            return weightedAverageDuration();
        else if (expiry != null && maturity == null)
            return yearsTo(expiry);
        return 0.0;
    }

    private double weightedAverageDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = payments.iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date()) * payment.amount();
        }
        if (commitment != 0.0)
            duration = weightedAverage / sumOfPayments;
        return duration;
    }

    private double yearsTo(Date endDate) {
        Date beginDate = (today == null ? start : today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }

    private double riskFactor() {
        return riskRating*2;
    }

    private double unusedRiskFactor() {
        return riskRating;
    }

    private double outstandingRiskAmount() {
        return outstanding;
    }

    private double unusedRiskAmount() {
        return (commitment - outstanding);
    }


    private float getUnusedPercentage() {
        return 4;
    }

    public void payment(double amount, Date date) {
        this.payments.add(Payment.payment(amount, date));
    }
}
