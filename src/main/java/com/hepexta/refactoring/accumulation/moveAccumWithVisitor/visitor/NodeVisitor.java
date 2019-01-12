package com.hepexta.refactoring.accumulation.moveAccumWithVisitor.visitor;

import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.EndTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.LinkTag;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.StringNode;
import com.hepexta.refactoring.accumulation.moveAccumWithVisitor.tag.Tag;

public interface NodeVisitor {
    void visitTag(Tag tag);
    void visitEndTag(EndTag endTag);
    void visitLinkTag(LinkTag link);
    void visitStringNode(StringNode stringNode);
}
