package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.TextExtractor;

public class StringNode implements Node {
    private String text;

    public String getText() {
        return text;
    }

    public void accept(TextExtractor textExtractor) {
        textExtractor.visitStringNode(this);
    }
}
