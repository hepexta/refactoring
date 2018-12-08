package com.hepexta.refactoring.creational.htmlparser;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    @Test
    public void testParser_shouldDecode() {
        Parser parser = new Parser();
        parser.setShouldDecode(true);

        Assert.assertEquals("DecodedStringNode", parser.parse());
    }

    @Test
    public void testParser_shouldNotDecode() {
        Parser parser = new Parser();
        parser.setShouldDecode(false);

        Assert.assertEquals("StringNode", parser.parse());
    }
}
