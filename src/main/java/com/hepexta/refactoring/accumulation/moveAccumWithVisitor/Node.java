package com.hepexta.refactoring.accumulation.moveAccumWithVisitor;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.visitor.NodeVisitor;

public interface Node {
    void accept(NodeVisitor nodeVisitor);
}
