package com.hepexta.refactoring.encapsuation.composit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void testBuildChildrenOfChildren() {
        String expectedXml =
                "<flavors>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement>" +
                            "</requirement>" +
                        "</requirements>" +
                    "</flavor>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
            builder.addChild("requirements");
                builder.addChild("requirement");
        String actualXml = builder.toXml();
        assertEquals(expectedXml, actualXml);
    }

    @Test
    public void testBuildSibling() {
        String expectedXml =
                "<flavors>" +
                    "<flavor1></flavor1>" +
                    "<flavor2></flavor2>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        String actualXml = builder.toXml();

        assertEquals(expectedXml, actualXml);
    }

    @Test
    public void testParents() {
        TagNode root = new TagNode("root");
        assertNull(root.getParent());

        TagNode childNode = new TagNode("child");
        root.add(childNode);
        assertEquals(root, childNode.getParent());
        assertEquals("root", childNode.getParent().getName());
    }
}
