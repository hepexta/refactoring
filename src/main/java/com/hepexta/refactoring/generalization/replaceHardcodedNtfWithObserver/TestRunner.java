package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result.TestResult;

import java.awt.*;

public class TestRunner extends Frame implements TestListener{   // TestRunner for AWT
    private TestResult fTestResult;
    private int count;

    protected TestResult createTestResult() {
        TestResult testResult = new TestResult();
        testResult.addObserver(this);
        return testResult;
    }
    synchronized public void runSuite() {
        fTestResult = createTestResult();
    }
    public void addFailure(TestResult result, Test test, Throwable t) {
        count++;
    }

    public void startTest(TestResult testResult, Test test) {
        // do smthk
    }

    public void addError(TestResult uiTestResult, Test test, Throwable t) {
        count++;
    }
}
