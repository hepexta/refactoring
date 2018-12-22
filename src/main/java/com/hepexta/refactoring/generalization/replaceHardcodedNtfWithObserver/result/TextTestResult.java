package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.Test;

public class TextTestResult extends TestResult{
    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
        System.out.println("E");
    }
    public synchronized void addFailure(Test test, Throwable t) {
        super.addFailure(test, t);
        System.out.print("F");
    }

    public synchronized void startTest(Test test) {
        super.startTest(test);
        System.out.print("S");
    }
}
