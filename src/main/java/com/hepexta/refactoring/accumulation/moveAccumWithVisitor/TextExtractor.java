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

    public String extractText()  {
        boolean isPreTag = false;
        boolean isScriptTag = false;
        StringBuffer results = new StringBuffer();

        for (Node node: nodes) {
            if (node instanceof StringNode) {
                if (!isScriptTag) {
                    StringNode stringNode = (StringNode) node;
                    if (isPreTag)
                        results.append(stringNode.getText());
                    else {
                        String text = stringNode.getText();
                        if (getReplaceNonBreakingSpace())
                            text = text.replace("\\a0", " ");
                        if (getCollapse())
                            collapse(results, text);
                        else
                            results.append(text);
                    }
                }
            } else if (node instanceof LinkTag) {
                LinkTag link = (LinkTag) node;
                if (isPreTag)
                    results.append(link.getLinkText());
                else
                    collapse(results, link.getLinkText());
                if (getLinks()) {
                    results.append("<");
                    results.append(link.getLink());
                    results.append(">");
                }
            } else if (node instanceof EndTag) {
                EndTag endTag = (EndTag) node;
                String tagName = endTag.getTagName();

                if (tagName.equalsIgnoreCase("PRE"))
                    isPreTag = false;
                else if (tagName.equalsIgnoreCase("SCRIPT"))
                    isScriptTag = false;
            } else if (node instanceof Tag) {
                Tag tag = (Tag) node;
                String tagName = tag.getTagName();
                if (tagName.equalsIgnoreCase("PRE"))
                    isPreTag = true;
                else if (tagName.equalsIgnoreCase("SCRIPT"))
                    isScriptTag = true;
            }
        }
        return (results.toString());
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
