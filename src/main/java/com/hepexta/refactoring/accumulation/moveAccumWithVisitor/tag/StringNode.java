package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;

public class StringNode implements Node {
    private String text;

    public String getText() {
        return text;
    }
}
