package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.Test;
import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.TestListener;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestResult {

    protected Vector fFailures;
    protected Vector fErrors;
    protected int fRunTests;
    private List observers = new ArrayList();

    public void addObserver(TestListener testListener) {
        observers.add(testListener);
    }

    protected void addFailure(Test test, Throwable t) {
        fFailures.add(new Pair<>(test, t));
        for (Iterator i = observers.iterator(); i.hasNext();) {
            TestListener observer = (TestListener)i.next();
            observer.addFailure(this, test, t);
        }
    }

    protected void addError(Test test, Throwable t) {
        fErrors.add(new Pair<>(test, t));
        for (Iterator i = observers.iterator(); i.hasNext();) {
            TestListener observer = (TestListener)i.next();
            observer.addError(this, test, t);
        }
    }

    protected void startTest(Test test) {
        final int count = test.countTestCases();
        synchronized (this) {
            fRunTests += count;
        }
        for (Iterator i = observers.iterator(); i.hasNext();) {
            TestListener observer = (TestListener)i.next();
            observer.startTest(this, test);
        }
    }
}
