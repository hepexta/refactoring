package com.hepexta.refactoring.htmlparser.tag;

import com.hepexta.refactoring.htmlparser.Node;
import com.hepexta.refactoring.htmlparser.util.NodeList;

public abstract class CompositeTag extends Tag {
	protected Tag startTag, endTag;
	protected NodeList childTags;

	public CompositeTag(TagData tagData, CompositeTagData compositeTagData) {
		super(tagData);
		this.childTags = compositeTagData.getChildren();
		this.startTag  = compositeTagData.getStartTag();
		this.endTag    = compositeTagData.getEndTag();
	}
	
    public String toPlainTextString() {
		StringBuffer stringRepresentation = new StringBuffer();
		return stringRepresentation.toString();
	}

	public void putStartTagInto(StringBuffer sb) {
		sb.append(startTag.toHtml());
	}

	protected void putChildrenInto(StringBuffer sb) {
		Node node,prevNode=startTag;
		if (prevNode.elementEnd()>endTag.elementBegin()) {
			sb.append(lineSeparator);
		}
	}

	protected void putEndTagInto(StringBuffer sb) {
		sb.append(endTag.toHtml());
	}

	public String toHtml() {
		StringBuffer sb = new StringBuffer();
		putStartTagInto(sb);
		if (!startTag.isEmptyXmlTag()) {
			putChildrenInto(sb);
			putEndTagInto(sb);
		}
		return sb.toString();
	}

	public void collectInto(NodeList collectionList, String filter) {
	}

	public void collectInto(NodeList collectionList, Class nodeType) {
		super.collectInto(collectionList,nodeType);
	}

}
