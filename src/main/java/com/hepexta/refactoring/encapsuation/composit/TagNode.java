package com.hepexta.refactoring.encapsuation.composit;

import java.util.ArrayList;
import java.util.List;

public class TagNode {

    private final String name;
    private String value = "";
    private final StringBuffer attributes;
    private final List<TagNode> children;
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
}
