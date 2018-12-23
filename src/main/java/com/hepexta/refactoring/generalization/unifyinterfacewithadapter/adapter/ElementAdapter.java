package com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementAdapter implements XMLNode {
    Element element;
    Document document;

    public ElementAdapter(Element element, Document document) {
        this.element = element;
        this.document = document;
    }

    public Element getElement() {
        return element;
    }

    public void add(XMLNode child) {
        ElementAdapter childElement = (ElementAdapter)child;
        getElement().appendChild(childElement.getElement());
    }

    public void addAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    public void add(ElementAdapter child) {
        getElement().appendChild(child.getElement());
    }

    public void addValue(String value) {
        getElement().appendChild(document.createTextNode(value));
    }

    public XMLNode getParent() {
        return null;
    }
}
