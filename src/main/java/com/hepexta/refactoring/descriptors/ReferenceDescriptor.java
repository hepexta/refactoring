package com.hepexta.refactoring.descriptors;

public class ReferenceDescriptor extends AttributeDescriptor {

    private Class<String> stringClass;

    public ReferenceDescriptor() {
        super();
    }

    public ReferenceDescriptor(String name, Class parent, Class objectClass, Class<String> stringClass) {
        super(name, parent, objectClass);
        this.stringClass = stringClass;
    }
}
