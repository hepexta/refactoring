package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.Test;
import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.TestRunner;

public class UITestResult extends TestResult {
    private TestRunner fRunner;
    public UITestResult(TestRunner runner) {
        fRunner= runner;
    }
    public synchronized void addFailure(Test test, Throwable t) {
        super.addFailure(test, t);
        fRunner.addFailure(this, test, t);  // notification to TestRunner
    }

    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
        fRunner.addError(this, test, t);  // notification to TestRunner
    }
}
