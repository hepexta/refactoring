package com.hepexta.refactoring.htmlparser.tag;

public class TagData {
	private int tagBegin;
	private int tagEnd;
	private int startLine;
	private int endLine;
	private String tagContents;
	private String tagLine;
	private String urlBeingParsed;
	private boolean isXmlEndTag;
	
	public TagData(int tagBegin, int tagEnd, String tagContents,String tagLine) {
		this(tagBegin, tagEnd, 0, 0, tagContents, tagLine, "", false);
	}
	
	public TagData(int tagBegin, int tagEnd, String tagContents,String tagLine, String urlBeingParsed) {
		this(tagBegin, tagEnd, 0, 0, tagContents, tagLine, urlBeingParsed, false);
	}
	
	public TagData(int tagBegin, int tagEnd, int startLine, int endLine, String tagContents,String tagLine, String urlBeingParsed, boolean isXmlEndTag) {
		this.tagBegin = tagBegin;
		this.tagEnd   = tagEnd;
		this.startLine = startLine;
		this.endLine = endLine;
		this.tagContents = tagContents;
		this.tagLine = tagLine;	
		this.urlBeingParsed = urlBeingParsed;
		this.isXmlEndTag = isXmlEndTag;
	}
	
	public int getTagBegin() {
		return tagBegin;
	}

	public String getTagContents() {
		return tagContents;
	}

	public int getTagEnd() {
		return tagEnd;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagContents(String tagContents) {
		this.tagContents = tagContents;
	}

	public String getUrlBeingParsed() {
		return urlBeingParsed;
	}

	public void setUrlBeingParsed(String baseUrl) {
		this.urlBeingParsed = baseUrl;
	}
	
	public boolean isEmptyXmlTag() {
		return isXmlEndTag;
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}
	
}
