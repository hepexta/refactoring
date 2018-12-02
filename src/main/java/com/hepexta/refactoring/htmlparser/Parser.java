package com.hepexta.refactoring.htmlparser;

import com.hepexta.refactoring.htmlparser.parser.ParserHelper;

import java.io.*;
import java.net.URLConnection;

public class Parser implements Serializable {

    protected static final String DEFAULT_CHARSET = "ISO-8859-1";
    protected String resourceLocn;
    protected transient NodeReader reader;
    protected String character_set;
    protected transient URLConnection url_conn;
    protected transient BufferedInputStream input;

    boolean shouldDecodeNodes;
    boolean shouldRemoveEscapeCharacters;

    public Parser() {
        resourceLocn = null;
        reader = null;
        character_set = DEFAULT_CHARSET;
        url_conn = null;
        input = null;
    }

    public Parser(NodeReader reader) {
        this();
        this.reader = reader;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public boolean shouldDecodeNodes() {
        return shouldDecodeNodes;
    }

    public void setShouldDecodeNodes(boolean shouldDecodeNodes) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }

    public boolean shouldRemoveEscapeCharacters() {
        return shouldRemoveEscapeCharacters;
    }

    public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters) {
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }
}
