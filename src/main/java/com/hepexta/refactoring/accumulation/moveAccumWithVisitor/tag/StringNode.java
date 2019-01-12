package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.visitor.NodeVisitor;

public class StringNode implements Node {
    private String text;

    public String getText() {
        return text;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitStringNode(this);
    }
}
