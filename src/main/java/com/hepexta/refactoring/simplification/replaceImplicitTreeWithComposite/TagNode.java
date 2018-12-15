package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

public class TagNode {
    private String name = "";
    private String value = "";
    private StringBuffer attributes;

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
        String result;
        result = "<" + name + attributes + ">" +
                        value +
                        "</" + name + ">";
        return result;
    }
}