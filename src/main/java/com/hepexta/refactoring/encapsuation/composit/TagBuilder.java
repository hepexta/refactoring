package com.hepexta.refactoring.encapsuation.composit;

public class TagBuilder {
    private TagNode rootNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }
}
