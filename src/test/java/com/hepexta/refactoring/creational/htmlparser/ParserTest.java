package com.hepexta.refactoring.creational.htmlparser;

import com.hepexta.refactoring.creational.htmlparser.factory.NodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    @Test
    public void testParser_shouldDecode() {
        Parser parser = new Parser();
        parser.setNodeFactory(new NodeFactory(true));

        Assert.assertEquals("DecodedStringNode", parser.parse());
    }

    @Test
    public void testParser_shouldNotDecode() {
        Parser parser = new Parser();
        parser.setNodeFactory(new NodeFactory(false));

        Assert.assertEquals("StringNode", parser.parse());
    }
}
