package com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver;

import com.hepexta.refactoring.generalization.replaceHardcodedNtfWithObserver.result.TestResult;

public interface TestListener {
    void addError(TestResult testResult, Test test, Throwable t);
    void addFailure(TestResult testResult, Test test, Throwable t);
    void startTest(TestResult testResult, Test test);
}
