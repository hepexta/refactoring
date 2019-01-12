package com.hepexta.refactoring.accumulation.moveAccumWithVisitor;


import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.EndTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.LinkTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.StringNode;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.Tag;

import java.util.ArrayList;
import java.util.List;

public class TextExtractor {

    List<Node> nodes = new ArrayList<>();
    private boolean collapse;
    private boolean links;
    private boolean isPreTag;
    private boolean isScriptTag;
    private StringBuffer results;

    public String extractText()  {
        isPreTag = false;
        isScriptTag = false;
        results = new StringBuffer();

        for (Node node: nodes) {
            if (node instanceof StringNode) {
                accept((StringNode) node);
            } else if (node instanceof LinkTag) {
                accept((LinkTag) node);
            } else if (node instanceof EndTag) {
                accept((EndTag) node);
            } else if (node instanceof Tag) {
                accept((Tag) node);
            }
        }
        return (results.toString());
    }

    private void accept(Tag node) {
        visitTagNode(node);
    }

    private void visitTagNode(Tag node) {
        String tagName = node.getTagName();
        if (tagName.equalsIgnoreCase("PRE"))
            isPreTag = true;
        else if (tagName.equalsIgnoreCase("SCRIPT"))
            isScriptTag = true;
    }

    private void accept(EndTag node) {
        visitEndTagNode(node);
    }

    private void visitEndTagNode(EndTag node) {
        String tagName = node.getTagName();
        if (tagName.equalsIgnoreCase("PRE"))
            isPreTag = false;
        else if (tagName.equalsIgnoreCase("SCRIPT"))
            isScriptTag = false;
    }

    private void accept(LinkTag node) {
        visitLinkTagNode(node);
    }

    private void visitLinkTagNode(LinkTag node) {
        if (isPreTag)
            results.append(node.getLinkText());
        else
            collapse(results, node.getLinkText());
        if (getLinks()) {
            results.append("<");
            results.append(node.getLink());
            results.append(">");
        }
    }

    private void accept(StringNode node) {
        visitStringNode(node);
    }

    private void visitStringNode(StringNode node) {
        if (!isScriptTag) {
            if (isPreTag)
                results.append(node.getText());
            else {
                String text = node.getText();
                if (getReplaceNonBreakingSpace())
                    text = text.replace("\\a0", " ");
                if (getCollapse())
                    collapse(results, text);
                else
                    results.append(text);
            }
        }
    }

    private boolean getReplaceNonBreakingSpace() {
        return false;
    }

    private void collapse(StringBuffer results, String text) {
        collapse = results.toString().contains(text);
    }

    public boolean getCollapse() {
        return collapse;
    }

    public boolean getLinks() {
        return links;
    }
}
