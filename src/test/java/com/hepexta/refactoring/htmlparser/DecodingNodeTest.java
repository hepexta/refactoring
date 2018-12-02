package com.hepexta.refactoring.htmlparser;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DecodingNodeTest {

    @Test
    public void testDecodeAmpersand() {
        Parser parser = new Parser();
        NodeFactory decodeNodes = new NodeFactory();
        decodeNodes.setDecodeStringNodes(true);
        parser.setNodeFactory(decodeNodes);

        assertTrue(parser.getNodeFactory().shouldDecodeStringNodes());
    }
}
