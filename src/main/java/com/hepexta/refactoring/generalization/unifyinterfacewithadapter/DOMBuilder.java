package com.hepexta.refactoring.generalization.unifyinterfacewithadapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.LinkedList;

public class DOMBuilder extends AbstractBuilder{
    private Document document;
    private Element root;
    private Element parent;
    private Element current;
    private LinkedList<Element> history = new LinkedList<>();
    private final static String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";

    public DOMBuilder(Document document, String element) {
        this.document = document;
        this.current = document.createElement(element);
        this.root = current;
    }

    public void addAttribute(String name, String value) {
        current.setAttribute(name, value);
    }

    public void addBelow(String child) {
        Element childNode = document.createElement(child);
        current.appendChild(childNode);
        parent = current;
        current = childNode;
        history.push(current);
    }

    public void addBeside(String sibling) {
        if (current == root)
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        Element siblingNode = document.createElement(sibling);
        parent.appendChild(siblingNode);
        current = siblingNode;
        history.pop();
        history.push(current);
    }

    public void addValue(String value) {
        current.appendChild(document.createTextNode(value));
    }

}
