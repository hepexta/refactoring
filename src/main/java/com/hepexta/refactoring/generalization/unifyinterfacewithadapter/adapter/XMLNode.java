package com.hepexta.refactoring.generalization.unifyinterfacewithadapter.adapter;

public interface XMLNode {
    void add(XMLNode childNode);
    void addAttribute(String attribute, String value);
    void addValue(String value);
    XMLNode getParent();
}
