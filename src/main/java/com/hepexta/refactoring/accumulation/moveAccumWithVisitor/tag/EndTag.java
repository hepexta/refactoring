package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.TextExtractor;

public class EndTag implements Node {
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void accept(TextExtractor textExtractor) {
        textExtractor.visitEndTagNode(this);
    }
}
