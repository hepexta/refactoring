package com.hepexta.refactoring.creational.htmlparser;

import com.hepexta.refactoring.creational.htmlparser.factory.NodeFactory;

public class Parser {

    private NodeFactory nodeFactory;

    public String parse(){
        return nodeFactory.createStringNode().getName();
    }

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }
}
