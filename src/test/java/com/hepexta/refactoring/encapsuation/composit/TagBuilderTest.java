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

    @Test
    public void testRepeatingChildrenAndGrandchildren() {
        String expectedXml =
                "<flavors>"+
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement>" +
                            "</requirement>" +
                        "</requirements>" +
                    "</flavor>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement>" +
                            "</requirement>" +
                        "</requirements>" +
                    "</flavor>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        for (int i=0; i<2; i++) {
            builder.addToParent("flavors", "flavor");
                builder.addChild("requirements");
                    builder.addChild("requirement");
        }

        assertEquals(expectedXml, builder.toXml());
    }

    @Test(expected = RuntimeException.class)
    public void testParentNameNotFound() {
        TagBuilder builder = new TagBuilder("flavors");
        for (int i=0; i<2; i++) {
            builder.addToParent("notFound", "flavor");
            builder.addChild("requirements");
            builder.addChild("requirement");
        }
    }
}
