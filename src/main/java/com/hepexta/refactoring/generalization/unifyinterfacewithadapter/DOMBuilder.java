package com.hepexta.refactoring.generalization.unifyinterfacewithadapter;

import com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter.ElementAdapter;
import com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter.XMLNode;
import org.w3c.dom.Document;

import java.util.LinkedList;

public class DOMBuilder extends AbstractBuilder{
    private Document document;
    private XMLNode root;
    private XMLNode parent;
    private XMLNode currentNode;
    private LinkedList<XMLNode> history = new LinkedList<>();
    private final static String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";

    public void addAttribute(String name, String value) {
        currentNode.addAttribute(name, value);
    }

    public void addChild(String childTagName) {
        XMLNode childNode = new ElementAdapter(document.createElement(childTagName), document);
        currentNode.add(childNode);
        parent = currentNode;
        currentNode = childNode;
        history.push(currentNode);
    }

    public void addSibling(String siblingTagName) {
        if (currentNode == root)
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        XMLNode siblingNode = new ElementAdapter(document.createElement(siblingTagName), document);
        parent.add(siblingNode);
        currentNode = siblingNode;
        history.pop();
        history.push(currentNode);
    }

    public void addValue(String value) {
        currentNode.addValue(value);
    }

}
