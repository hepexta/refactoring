package com.hepexta.refactoring.simplification.embelishmenttodecorator;

import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.DecodedStringNode;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.Node;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.StringNode;

public class StringParserCondition {

    private static StringNode stringNode = new StringNode();
    private static DecodedStringNode decodedStringNode = new DecodedStringNode(stringNode);

    public static Node createStringNode(Parser parser){
        return parser.shouldDecode() ? decodedStringNode : stringNode;
    }
}
