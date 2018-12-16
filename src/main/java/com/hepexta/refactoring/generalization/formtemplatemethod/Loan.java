package com.hepexta.refactoring.generalization.formtemplatemethod;

public class Loan {
    private double commitment;
    private double unusedPercentage;
    private double riskFactor;
    private double duration;
    private double averageDuration;
    private double unusedRiskFactor;
    private double outstandingRiskAmount;

    public double getCommitment() {
        return commitment;
    }

    public void setCommitment(double commitment) {
        this.commitment = commitment;
    }

    public double getUnusedPercentage() {
        return unusedPercentage;
    }

    public void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(double averageDuration) {
        this.averageDuration = averageDuration;
    }

    public void setOutstandingRiskAmount(double outstandingRiskAmount) {
        this.outstandingRiskAmount = outstandingRiskAmount;
    }

    public double outstandingRiskAmount() {
        return outstandingRiskAmount;
    }

    public double getUnusedRiskFactor() {
        return unusedRiskFactor;
    }

    public void setUnusedRiskFactor(double unusedRiskFactor) {
        this.unusedRiskFactor = unusedRiskFactor;
    }

    public double unusedRiskAmount() {
        return getUnusedRiskFactor() * getCommitment();
    }
}
