package com.hepexta.refactoring.accumulation.moveAccumWithCollectParam;

import org.junit.Assert;
import org.junit.Test;

public class TagNodeTest {
    @Test
    public void testTagNode() {
        TagNode tagNode = new TagNode("body");
        TagNode input = new TagNode("input");
        input.addAttribute("type", "button");
        input.addAttribute("class", "submit");
        input.addValue("submit");
        tagNode.add(input);

        String expected =
                "<body>" +
                    "<input type='button' class='submit'>submit</input>" +
                "</body>";
        Assert.assertEquals(expected, tagNode.toString());
    }
}
