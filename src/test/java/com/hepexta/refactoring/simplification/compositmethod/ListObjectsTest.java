package com.hepexta.refactoring.simplification.compositmethod;

import org.junit.Assert;
import org.junit.Test;

public class ListObjectsTest {

    @Test
    public void test_add() {
        ListObjects listObjects = new ListObjects();
        listObjects.add(new Object());
        listObjects.add(new Object());
        listObjects.add(new Object());

        Assert.assertEquals(3, listObjects.size());
    }

    @Test
    public void test_readOnly() {
        ListObjects listObjects = new ListObjects(true);
        listObjects.add(new Object());
        listObjects.add(new Object());
        listObjects.add(new Object());

        Assert.assertEquals(0, listObjects.size());
    }
}
