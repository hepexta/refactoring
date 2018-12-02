
package com.hepexta.refactoring.htmlparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class NodeReader extends BufferedReader {
    protected int posInLine = -1;
    protected String line;
    protected Node node = null;
    protected String url;
    private Parser parser;
    private int lineCount;

    public NodeReader(Reader in, int len, String url) {
        super(in, len);
        this.url = url;
        this.parser = null;
        this.lineCount = 1;
    }

    public NodeReader(Reader in, int len) {
        this(in, len, "");
    }

    public NodeReader(Reader in, String url) {
        this(in, 8192, url);
    }


    public int getLastLineNumber() {
        return lineCount - 1;
    }

    public void setParser(Parser newParser) {
        parser = newParser;
    }

    public void reset() throws IOException {
        super.reset();
        lineCount = 1;
        posInLine = -1;
    }

}
