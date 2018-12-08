package com.hepexta.refactoring.encapsuation.composit;

public class TagBuilder {
    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
        currentNode = rootNode;
    }

    public String toXml() {
        return rootNode.toString();
    }

    public void addChild(String childTagName) {
        TagNode parentNode = currentNode;
        currentNode = new TagNode(childTagName);
        parentNode.add(currentNode);
    }

    public void addSibling(String siblingTagName) {
        rootNode.add(new TagNode(siblingTagName));
    }
}
