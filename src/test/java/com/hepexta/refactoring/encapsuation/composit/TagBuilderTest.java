package com.hepexta.refactoring.encapsuation.composit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagBuilderTest {

    @Test
    public void testBuildOneNode() {
        String expectedXml =
                "<flavors>" +
                    "<flavor>" +
                    "</flavor>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        String actualXml = builder.toXml();
        assertEquals(expectedXml, actualXml);
    }
}
