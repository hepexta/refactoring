
package com.hepexta.refactoring.htmlparser.tag;

import com.hepexta.refactoring.htmlparser.Node;
import com.hepexta.refactoring.htmlparser.NodeReader;
import com.hepexta.refactoring.htmlparser.ParserException;
import com.hepexta.refactoring.htmlparser.parser.AttributeParser;
import com.hepexta.refactoring.htmlparser.parser.TagParser;
import com.hepexta.refactoring.htmlparser.util.NodeList;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class Tag extends Node {
    public final static String TAGNAME = "$<TAGNAME>$";
    public final static String EMPTYTAG = "$<EMPTYTAG>$";
    private final static String EMPTY_STRING = "";

    private static AttributeParser paramParser = new AttributeParser();
    private static TagParser tagParser;

    protected StringBuffer tagContents;
    private boolean emptyXmlTag = false;

    protected Hashtable attributes = null;

    private String tagLine;

    /**
     * The combined text of all the lines spanned by this tag
     */
    private String[] tagLines;

    /**
     * The line number on which this tag starts
     */
    private int startLine;

    protected static HashSet breakTags;

    static {
        breakTags = new HashSet(30);
    }


    public Tag(TagData tagData) {
        super(tagData.getTagBegin(), tagData.getTagEnd());
        this.startLine = tagData.getStartLine();
        this.tagContents = new StringBuffer();
        this.tagContents.append(tagData.getTagContents());
        this.tagLine = tagData.getTagLine();
        this.tagLines = new String[]{tagData.getTagLine()};
        this.emptyXmlTag = tagData.isEmptyXmlTag();
    }

    public static Tag find(NodeReader reader, String input, int position) {
        return tagParser.find(reader, input, position);
    }

    private Hashtable parseAttributes() {
        return paramParser.parseAttributes(this);
    }

    public String getAttribute(String name) {
        return (String) getAttributes().get(name.toUpperCase());
    }

    public Hashtable getAttributes() {
        if (attributes == null) {
            attributes = parseAttributes();
        }
        return attributes;
    }

    public String getTagName() {
        return (String) getAttributes().get(TAGNAME);
    }

    public String getText() {
        return tagContents.toString();
    }

    public Node scan(Map scanners, String url, NodeReader reader) throws ParserException {
        return null;
    }

    public void setAttributes(Hashtable attributes) {
        this.attributes = attributes;
    }

    public void setTagBegin(int tagBegin) {
        this.nodeBegin = tagBegin;
    }

    public int getTagBegin() {
        return (nodeBegin);
    }

     public void setTagEnd(int tagEnd) {
        this.nodeEnd = tagEnd;
    }

    public int getTagEnd() {
        return (nodeEnd);
    }


    public int getTagStartLine() {
        return startLine;
    }

    public void setTagLine(String newTagLine) {
        tagLine = newTagLine;

        // Note: Incur the overhead of resizing each time (versus
        // preallocating a larger array), since the average tag
        // generally doesn't span multiple lines
        String[] newTagLines = new String[tagLines.length + 1];
        for (int i = 0; i < tagLines.length; i++)
            newTagLines[i] = tagLines[i];
        newTagLines[tagLines.length] = newTagLine;
        tagLines = newTagLines;
    }

    public void setText(String text) {
        tagContents = new StringBuffer(text);
    }

    public String toPlainTextString() {
        return EMPTY_STRING;
    }

    public String toHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(getTagName());
        if (containsMoreThanOneKey()) sb.append(" ");
        String key, value;
        String empty = null;
        int i = 0;
        for (Enumeration e = attributes.keys(); e.hasMoreElements(); ) {
            key = (String) e.nextElement();
            i++;
            if (!key.equals(TAGNAME)) {
                if (key.equals(EMPTYTAG)) {
                    empty = "/";
                } else {
                    value = getAttribute(key);
                    sb.append(key + "=\"" + value + "\"");
                    if (i < attributes.size()) sb.append(" ");
                }
            }
        }
        if (empty != null) sb.append(empty);
        if (isEmptyXmlTag()) sb.append("/");
        sb.append(">");
        return sb.toString();
    }

    private boolean containsMoreThanOneKey() {
        return attributes.keySet().size() > 1;
    }

    /**
     * Print the contents of the tag
     */
    public String toString() {
        return "Begin Tag : " + tagContents + "; begins at : " + elementBegin() + "; ends at : " + elementEnd();
    }


    public void collectInto(NodeList collectionList, String filter) {
    }

    public Hashtable getParsed() {
        return attributes;
    }

    public boolean isEmptyXmlTag() {
        return emptyXmlTag;
    }

    public void setEmptyXmlTag(boolean emptyXmlTag) {
        this.emptyXmlTag = emptyXmlTag;
    }

}
