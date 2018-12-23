package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.Test;
import javafx.util.Pair;

import java.util.Vector;

public class TestResult {

    protected Vector fFailures;
    protected Vector fErrors;
    protected int fRunTests;

    protected void addFailure(Test test, Throwable t) {
        fFailures.add(new Pair<>(test, t));
    }

    protected void addError(Test test, Throwable t) {
        fErrors.add(new Pair<>(test, t));
    }

    protected void startTest(Test test) {
        final int count = test.countTestCases();
        synchronized (this) {
            fRunTests += count;
        }
    }
}
