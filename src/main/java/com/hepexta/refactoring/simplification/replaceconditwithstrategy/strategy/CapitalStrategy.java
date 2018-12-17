package com.hepexta.refactoring.simplification.replaceconditwithstrategy.strategy;

import com.hepexta.refactoring.simplification.replaceconditwithstrategy.Loan;
import java.util.Date;

public abstract class CapitalStrategy {

    private static final long MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;
    private Date today = null;

    abstract public double capital(Loan loan);

    abstract public double duration(Loan loan);

    double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (today == null ? loan.getStart() : today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}
