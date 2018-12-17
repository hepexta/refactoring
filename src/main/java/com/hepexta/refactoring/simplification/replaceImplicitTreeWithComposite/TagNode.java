package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {
    private String name = "";
    private String value = "";
    private StringBuffer attributes;
    private List children;

    public TagNode(String name) {
        this.name = name;
        attributes = new StringBuffer("");
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("=’");
        attributes.append(value);
        attributes.append("’");
    }

    public void addValue(String value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder result;
        result = new StringBuilder("<" + name + attributes + ">");
        Iterator it = children().iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode)it.next();
            result.append(node.toString());
        }
        result.append(value);
        result.append("</").append(name).append(">");
        return result.toString();
    }

    private List children() {
        if (children == null)
            children = new ArrayList();
        return children;
    }

    public void add(TagNode child) {
        children().add(child);
    }

}