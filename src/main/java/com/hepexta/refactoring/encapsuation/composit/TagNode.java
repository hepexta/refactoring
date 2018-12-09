package com.hepexta.refactoring.encapsuation.composit;

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

    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder("<" + name + attributes + ">");
        for (Object aChildren : this.children) {
            TagNode node = (TagNode) aChildren;
            result.append(node.toString());
        }
        result.append(value);
        result.append("</").append(name).append(">");
        return result.toString();
    }

    public void add(TagNode node) {
        node.setParent(this);
        this.children.add(node);
    }

    private void setParent(TagNode tagNode) {
        this.parent = tagNode;
    }

    public TagNode getParent() {
        return this.parent;
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
