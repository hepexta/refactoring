package com.hepexta.refactoring.htmlparser.tag;

import com.hepexta.refactoring.htmlparser.util.NodeList;

public class CompositeTagData {
	private Tag startTag;
	private Tag endTag;
	private NodeList children;
	
	public CompositeTagData(
		Tag startTag, Tag endTag, NodeList children) {
		this.startTag = startTag;
		this.endTag   = endTag;
		this.children = children;
	}

	public NodeList getChildren() {
		return children;
	}

	public Tag getEndTag() {
		return endTag;
	}

	public Tag getStartTag() {
		return startTag;
	}
	
	public String toString() {
		StringBuffer childrenString = new StringBuffer();
		for (int i=0;i<children.size();i++)
			childrenString.append(children.elementAt(i).toPlainTextString());
		return childrenString.toString();
	}
}
