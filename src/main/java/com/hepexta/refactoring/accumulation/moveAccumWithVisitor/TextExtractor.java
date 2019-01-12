package com.hepexta.refactoring.accumulation.moveAccumWithVisitor;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.EndTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.LinkTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.StringNode;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.Tag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.visitor.NodeVisitor;

import java.util.ArrayList;
import java.util.List;

public class TextExtractor implements NodeVisitor {

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
            node.accept(this);
        }
        return (results.toString());
    }

    public void visitTag(Tag node) {
        String tagName = node.getTagName();
        if (tagName.equalsIgnoreCase("PRE"))
            isPreTag = true;
        else if (tagName.equalsIgnoreCase("SCRIPT"))
            isScriptTag = true;
    }

    public void visitEndTag(EndTag node) {
        String tagName = node.getTagName();
        if (tagName.equalsIgnoreCase("PRE"))
            isPreTag = false;
        else if (tagName.equalsIgnoreCase("SCRIPT"))
            isScriptTag = false;
    }

    public void visitLinkTag(LinkTag node) {
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

    public void visitStringNode(StringNode node) {
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
