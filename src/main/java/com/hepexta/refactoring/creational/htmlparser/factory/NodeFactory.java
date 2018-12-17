package com.hepexta.refactoring.creational.htmlparser.factory;

import com.hepexta.refactoring.creational.htmlparser.node.DecodedStringNode;
import com.hepexta.refactoring.creational.htmlparser.node.Node;
import com.hepexta.refactoring.creational.htmlparser.node.StringNode;

public class NodeFactory {

    private boolean decodeStringNodes;

    public NodeFactory(boolean decodeStringNodes) {
        this.decodeStringNodes = decodeStringNodes;
    }

    public Node createStringNode() {
        if (decodeStringNodes) {
            return new DecodedStringNode();
        }
        return new StringNode();
    }
}
