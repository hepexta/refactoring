package com.hepexta.refactoring.creational.htmlparser;

import com.hepexta.refactoring.creational.htmlparser.node.DecodedStringNode;
import com.hepexta.refactoring.creational.htmlparser.node.Node;
import com.hepexta.refactoring.creational.htmlparser.node.StringNode;

public class StringParser {

    public static Node createStringNode(Parser parser){
        return parser.shouldDecode() ? new DecodedStringNode() : new StringNode();
    }
}
