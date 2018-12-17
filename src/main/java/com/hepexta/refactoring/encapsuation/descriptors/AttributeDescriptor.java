package com.hepexta.refactoring.encapsuation.descriptors;

import java.util.Date;

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

    public static AttributeDescriptor forInteger(String name, Class parent) {
        return new DefaultDescriptor(name, parent, Integer.TYPE);
    }

    public static AttributeDescriptor forDate(String name, Class parent) {
        return new DefaultDescriptor(name, parent, Date.class);
    }

    public static AttributeDescriptor forBoolean(String name, Class parent) {
        return new DefaultDescriptor(name, parent, Boolean.TYPE);
    }

    public String getName() {
        return name;
    }

    public Class getParentType() {
        return parentType;
    }

    public Class getType() {
        return type;
    }
}
