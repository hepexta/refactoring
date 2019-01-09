package com.hepexta.refactoring.accumulation.moveAccumWithCollectParam;

import java.util.ArrayList;
import java.util.List;

public class TagNode {

    private final String name;
    private String value = "";
    private final StringBuffer attributes;
    private final List<TagNode> children;
    private TagNode parent;

    public TagNode(String name) {
        this.name = name;
        this.attributes = new StringBuffer("");
        this.children = new ArrayList<>();
    }

    public String toString() {
        StringBuffer result = new StringBuffer("");
        appendContentsTo(result);
        return result.toString();
    }

    private void appendContentsTo(StringBuffer result) {
        writeOpenTagTo(result);
        writeChildrenTo(result);
        writeValueTo(result);
        writeEndTagTo(result);
    }

    private void writeOpenTagTo(StringBuffer result) {
        result.append("<");
        result.append(name);
        result.append(attributes.toString());
        result.append(">");
    }

    private void writeChildrenTo(StringBuffer result) {
        for (TagNode node : children) {
            node.appendContentsTo(result);  // now recursive call will work
        }
    }

    private void writeValueTo(StringBuffer result) {
        if (!value.equals(""))
            result.append(value);
    }

    private void writeEndTagTo(StringBuffer result) {
        result.append("</");
        result.append(name);
        result.append(">");
    }

    public void add(TagNode node) {
        node.setParent(this);
        this.children.add(node);
    }

    private void setParent(TagNode tagNode) {
        this.parent = tagNode;
    }

    public String getName() {
        return this.name;
    }

    public void addAttribute(String name, String value) {
        attributes.append(" ").append(name).append("=").append("'").append(value).append("'");
    }

    public void addValue(String value) {
        this.value = value;
    }
}
