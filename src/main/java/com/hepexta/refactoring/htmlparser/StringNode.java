
package com.hepexta.refactoring.htmlparser;

import com.hepexta.refactoring.htmlparser.util.NodeList;

public class StringNode extends Node {
    public static final String STRING_FILTER = "-string";
    protected StringBuffer textBuffer;

    public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        super(textBegin, textEnd);
        this.textBuffer = textBuffer;
    }

    public String getText() {
        return textBuffer.toString();
    }

    public String toPlainTextString() {
        return textBuffer.toString();
    }

    public String toHtml() {
        return textBuffer.toString();
    }

    public String toString() {
        return "Text = " + getText() + "; begins at : " + elementBegin() + "; ends at : " + elementEnd();
    }

    public void collectInto(NodeList collectionList, String filter) {
        if (filter == STRING_FILTER) collectionList.add(this);
    }

}
