package com.hepexta.refactoring.embelishmenttodecorator;

import com.hepexta.refactoring.simplification.embelishmenttodecorator.Parser;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.StringParserCondition;
import com.hepexta.refactoring.simplification.embelishmenttodecorator.node.Node;
import org.junit.Assert;
import org.junit.Test;

public class StringParserConditionTest {
    @Test
    public void shouldDecode() {
        Node node = StringParserCondition.createStringNode(new Parser(true));
        Assert.assertEquals("DecodedStringNode", node.getName());
    }

    @Test
    public void shouldNotDecode() {
        Node node = StringParserCondition.createStringNode(new Parser(false));
        Assert.assertEquals("StringNode", node.getName());
    }
}
