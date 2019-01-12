package com.hepexta.refactoring.accumulation.moveAccumWithVisitor;

public interface Node {
    void accept(TextExtractor textExtractor);
}
