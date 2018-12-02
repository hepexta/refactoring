
package com.hepexta.refactoring.htmlparser;

public class DecodedStringNode extends StringNode {

    public DecodedStringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        super(textBuffer, textBegin, textEnd);
        System.out.println("Inside DecodedStringNode");
    }
}
