package com.hepexta.refactoring.encapsuation.descriptors;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttributeDescriptorTest {

    @Test
    public void client() {
        List<AttributeDescriptor> descriptors = createAttributeDescriptors();
        Assert.assertEquals(6, descriptors.size());
    }

    @Test
    public void test_DefaultDescriptor_integer() {
        String name = "remoteId";
        AttributeDescriptor integerDescriptor = DefaultDescriptor.forInteger(name, getClass());
        Assert.assertEquals(name, integerDescriptor.getName());
        Assert.assertEquals(Integer.TYPE, integerDescriptor.getType());
        Assert.assertEquals(getClass(), integerDescriptor.getParentType());
    }

    @Test
    public void test_DefaultDescriptor_date() {
        String name = "createdDate";
        AttributeDescriptor integerDescriptor = DefaultDescriptor.forDate(name, getClass());
        Assert.assertEquals(name, integerDescriptor.getName());
        Assert.assertEquals(Date.class, integerDescriptor.getType());
        Assert.assertEquals(getClass(), integerDescriptor.getParentType());
    }

    @Test
    public void test_ReferenceDescriptor() {
        String name = "createdBy";
        AttributeDescriptor integerDescriptor = ReferenceDescriptor.forObject(name, getClass(), String.class);
        Assert.assertEquals(name, integerDescriptor.getName());
        Assert.assertEquals(Object.class, integerDescriptor.getType());
        Assert.assertEquals(getClass(), integerDescriptor.getParentType());
    }

    private List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(AttributeDescriptor.forInteger("remoteId", getClass()));
        result.add(AttributeDescriptor.forDate("createdDate", getClass()));
        result.add(AttributeDescriptor.forDate("lastChangedDate", getClass()));
        result.add(ReferenceDescriptor.forObject("createdBy", getClass(), String.class));
        result.add(AttributeDescriptor.forInteger("optimisticLockVersion", getClass()));
        result.add(AttributeDescriptor.forBoolean("isColor", getClass()));
        return result;
    }

}
