package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.Node;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.TextExtractor;

public class LinkTag implements Node {
    private String linkText;
    private String link;

    public String getLinkText() {
        return linkText;
    }

    public String getLink() {
        return link;
    }

    public void accept(TextExtractor textExtractor) {
        textExtractor.visitLinkTagNode(this);
    }
}
