package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.visitor.NodeVisitor;

public class LinkTag implements Node {
    private String linkText;
    private String link;

    public String getLinkText() {
        return linkText;
    }

    public String getLink() {
        return link;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitLinkTag(this);
    }
}
