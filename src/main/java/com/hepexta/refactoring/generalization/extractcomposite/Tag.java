package com.hepexta.refactoring.generalization.extractcomposite;

public abstract class Tag {

    private String tagBegin;
    private String tagEnd;
    private String tagContents;
    private String tagLine;

    public Tag(String tagBegin, String tagEnd, String tagContents, String tagLine) {
        this.tagBegin = tagBegin;
        this.tagEnd = tagEnd;
        this.tagContents = tagContents;
        this.tagLine = tagLine;
    }

    public abstract String toPlainTextString();

}
