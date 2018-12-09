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
        addTo(this.currentNode, childTagName);
    }

    public void addSibling(String siblingTagName) {
        addTo(this.currentNode.getParent(), siblingTagName);
    }

    private void addTo(TagNode parentNode, String tagName) {
        currentNode = new TagNode(tagName);
        parentNode.add(currentNode);
    }

    public void addToParent(String parentTagName, String childTagName) {
        TagNode parent = findParentBy(parentTagName);
        if (parent == null){
            throw new RuntimeException("parentNode is null");
        }
        addTo(parent, childTagName);
    }

    private TagNode findParentBy(String parentTagName) {
        TagNode parentNode = currentNode;
        while (parentNode != null) {
            if (parentTagName.equals(parentNode.getName()))
                return parentNode;
            parentNode = parentNode.getParent();
        }
        return null;
    }
}
