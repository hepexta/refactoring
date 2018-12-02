package com.hepexta.refactoring.htmlparser.parser;

import com.hepexta.refactoring.htmlparser.Node;
import com.hepexta.refactoring.htmlparser.NodeReader;
import com.hepexta.refactoring.htmlparser.StringNode;

public class StringParser {

    private boolean beginTag(String line, int pos) {
        return false;
    }

    public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
        StringBuffer textBuffer = new StringBuffer();
        int textBegin = position;
        int textEnd = position;
        return StringNode.createStringNode(textBuffer, textBegin, textEnd, balance_quotes);
    }
}
