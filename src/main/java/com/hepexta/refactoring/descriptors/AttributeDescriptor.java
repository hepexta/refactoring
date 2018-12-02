package com.hepexta.refactoring.descriptors;

public abstract class AttributeDescriptor {

    private String name;
    private Class parentType;
    private Class type;

    protected AttributeDescriptor(String name, Class parentType, Class type) {
        this.name = name;
        this.parentType = parentType;
        this.type = type;
    }

    protected AttributeDescriptor() {
    }
}
