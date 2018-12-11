package com.hepexta.refactoring.simplification.embelishmenttodecorator;

import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.DecodedStringNode;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.Node;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.StringNode;

public class StringParserCondition {
    public static Node createStringNode(Parser parser){
        return parser.shouldDecode() ? new DecodedStringNode() : new StringNode();
    }
}
