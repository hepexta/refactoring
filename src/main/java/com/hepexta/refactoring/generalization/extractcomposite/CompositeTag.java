package com.hepexta.refactoring.generalization.extractcomposite;

import java.util.Enumeration;
import java.util.Vector;

public abstract class CompositeTag extends Tag{

    protected Vector<Enumeration> children;

    public CompositeTag(String tagBegin, String tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public Enumeration children() {
        return children.elements();
    }

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;
        for (Enumeration e = children(); e.hasMoreElements();) {
            node = (Node) e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }
}
