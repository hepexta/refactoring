package com.hepexta.refactoring.accumulation.moveAccumWithCollectParam;

import java.util.ArrayList;
import java.util.Iterator;
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
        String result = new String();
        result += "<" + this.name + attributes + ">";
        Iterator it = children.iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode)it.next();
            result += node.toString();
        }
        if (!value.equals(""))
            result += value;
        result += "</" + this.name + ">";
        return result;
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
