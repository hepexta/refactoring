package com.hepexta.refactoring.creational.htmlparser;

public class Parser {

    boolean shouldDecode;

    public String parse(){
        return StringParser.createStringNode(this).getName();
    }

    public boolean shouldDecode() {
        return shouldDecode;
    }

    public void setShouldDecode(boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

}
