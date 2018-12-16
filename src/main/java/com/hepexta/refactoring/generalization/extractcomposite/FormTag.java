package com.hepexta.refactoring.generalization.extractcomposite;

import java.util.Enumeration;
import java.util.Vector;

public class FormTag extends Tag {

    private Vector<Enumeration> allNodesVector;

    public FormTag(String tagBegin, String tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        StringBuffer stringRepresentation = new StringBuffer();
        Node node;

        for (Enumeration e = getAllNodesVector().elements(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            stringRepresentation.append(node.toPlainTextString());
        }
        return stringRepresentation.toString();
    }

    public Vector<Enumeration> getAllNodesVector() {
        return allNodesVector;
    }

    public void setAllNodesVector(Vector<Enumeration> allNodesVector) {
        this.allNodesVector = allNodesVector;
    }
}
