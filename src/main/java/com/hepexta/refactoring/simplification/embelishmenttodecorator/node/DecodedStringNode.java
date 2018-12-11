package com.hepexta.refactoring.simplification.embelishmenttodecorator.node;

public class DecodedStringNode extends Node {

    StringNode stringNode;

    public DecodedStringNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }

    @Override
    public String getName() {
        return "Decoded".concat(stringNode.getName());
    }
}
