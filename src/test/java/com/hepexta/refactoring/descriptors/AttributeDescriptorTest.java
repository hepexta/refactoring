package com.hepexta.refactoring.descriptors;

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

    private List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(new DefaultDescriptor("remoteId", getClass(), Integer.TYPE));
        result.add(new DefaultDescriptor("createdDate", getClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate", getClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy", getClass(), Object.class, String.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", getClass(), Integer.TYPE));
        result.add(new BooleanDescriptor("isColor", getClass()));
        return result;
    }
}
