package com.hepexta.refactoring.htmlparser;

import com.hepexta.refactoring.htmlparser.tag.CompositeTag;
import com.hepexta.refactoring.htmlparser.util.NodeList;

import java.io.*;

public abstract class Node implements Serializable {

	protected int nodeBegin;

	protected int nodeEnd;

	protected CompositeTag parent;
	
	protected static String lineSeparator = System.getProperty("line.separator", "\n");
	
	public Node(int nodeBegin, int nodeEnd) {
		this.nodeBegin = nodeBegin;
		this.nodeEnd   = nodeEnd;
		this.parent    = null;
	}

	public Node(int nodeBegin, int nodeEnd, CompositeTag parent) {
		this.nodeBegin = nodeBegin;
		this.nodeEnd   = nodeEnd;
		this.parent    = parent;
	}


	public static void setLineSeparator(String lineSeparator) {
		Node.lineSeparator = lineSeparator;
	}


	public static String getLineSeparator() {
		return Node.lineSeparator;
	}


	public abstract String toPlainTextString();

	public abstract String toHtml();


	public abstract String toString();


	public abstract void collectInto(NodeList collectionList, String filter);

	public void collectInto(NodeList collectionList, Class nodeType) {
		if (nodeType.getName().equals(this.getClass().getName())) {
			collectionList.add(this);
		}
	}

	public int elementBegin() {
		return nodeBegin;
	}

	public int elementEnd() {
		return nodeEnd;
	}

	public final String toHTML() {
		return toHtml();
	}
	
	public CompositeTag getParent() {
		return parent;
	}

	public void setParent(CompositeTag tag) {
		parent = tag;
	}

}
