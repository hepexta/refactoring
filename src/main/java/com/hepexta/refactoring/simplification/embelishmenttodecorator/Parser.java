package com.hepexta.refactoring.simplification.embelishmenttodecorator;

public class Parser {

    private boolean decode;

    public Parser(boolean decode) {
        this.decode = decode;
    }

    public boolean shouldDecode() {
        return decode;
    }
}
