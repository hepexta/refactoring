package com.hepexta.refactoring.encapsuation.descriptors;

public class BooleanDescriptor extends AttributeDescriptor {

    public BooleanDescriptor() {
        super();
    }

    public BooleanDescriptor(String name, Class parent) {
        super(name, parent, Boolean.TYPE);
    }
}
