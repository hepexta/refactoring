package com.hepexta.refactoring.htmlparser.parser;

import com.hepexta.refactoring.htmlparser.ParserException;

import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

public class ParserHelper implements Serializable {

    public ParserHelper() {
        super();
    }

    public static URLConnection openConnection(URL url, ParserFeedback feedback) throws ParserException {
        return null;
    }

    public static URLConnection openConnection(String string, ParserFeedback feedback) throws ParserException {
        return null;
    }

    public static String findCharset(String name, String _default) {
        return null;
    }

}
