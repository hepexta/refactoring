package com.hepexta.refactoring.encapsuation.composit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagBuilderTest {

    @Test
    public void testBuildOneNode() {
        String expectedXml =
                "<flavors></flavors>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertEquals(expectedXml, actualXml);
    }
}
