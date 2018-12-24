package com.hepexta.refactoring.generalization.unifyinterfacewithadapter;

import com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter.TagNode;
import com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter.XMLNode;

public class XMLBuilder extends AbstractBuilder implements XMLNode {
    private XMLNode rootNode;
    private XMLNode currentNode;

    public void addChild(String childTagName) {
        addTo(currentNode, childTagName);
    }

    public void addSibling(String siblingTagName) {
        addTo(currentNode.getParent(), siblingTagName);
    }

    private void addTo(XMLNode parentNode, String tagName) {
        currentNode = new TagNode(tagName);
        parentNode.add(currentNode);
    }

    @Override
    public void add(XMLNode child) {
        currentNode.add(child);
    }

    public void addAttribute(String name, String value) {
        currentNode.addAttribute(name, value);
    }

    public void addValue(String value) {
        currentNode.addValue(value);
    }

    public XMLNode getParent() {
        return currentNode.getParent();
    }
}
