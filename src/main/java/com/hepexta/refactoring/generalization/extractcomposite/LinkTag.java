package com.hepexta.refactoring.generalization.extractcomposite;

import java.util.Enumeration;
import java.util.Vector;

public class LinkTag extends Tag {

    private Vector nodeVector;
    private Enumeration linkData;

    public LinkTag(String tagBegin, String tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;
        for (Enumeration e = getLinkData(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }


    public Enumeration getLinkData() {
        return linkData;
    }

    public void setLinkData(Enumeration linkData) {
        this.linkData = linkData;
    }
}
