package com.hepexta.refactoring.htmlparser.parser;

import com.hepexta.refactoring.htmlparser.NodeReader;
import com.hepexta.refactoring.htmlparser.tag.Tag;
import com.hepexta.refactoring.htmlparser.tag.TagData;

public class TagParser {

    public Tag find(NodeReader reader, String input, int position) {
        return new Tag(new TagData(position, 0, reader.getLastLineNumber(), 0, "", input, "", false));
    }

}
