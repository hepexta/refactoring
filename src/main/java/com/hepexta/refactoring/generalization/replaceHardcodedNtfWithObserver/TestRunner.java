package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result.TestResult;
import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result.UITestResult;

import java.awt.*;

public class TestRunner extends Frame {   // TestRunner for AWT
    private TestResult fTestResult;
    private int count;

    protected TestResult createTestResult() {
        return new UITestResult(this);   // hard-coded to UITestResult
    }
    synchronized public void runSuite() {
        fTestResult = createTestResult();
    }
    public void addFailure(TestResult result, Test test, Throwable t) {
        count++;
    }

    public void addError(UITestResult uiTestResult, Test test, Throwable t) {
        count++;
    }
}
