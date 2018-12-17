package com.hepexta.refactoring.encapsuation.descriptors;

public class ReferenceDescriptor extends AttributeDescriptor {

    private Class<String> stringClass;

    public ReferenceDescriptor() {
        super();
    }

    public ReferenceDescriptor(String name, Class parent, Class objectClass, Class<String> stringClass) {
        super(name, parent, objectClass);
        this.stringClass = stringClass;
    }

    public static ReferenceDescriptor forObject(String name, Class parent, Class<String> stringClass) {
        return new ReferenceDescriptor(name, parent, Object.class, stringClass);
    }
}
