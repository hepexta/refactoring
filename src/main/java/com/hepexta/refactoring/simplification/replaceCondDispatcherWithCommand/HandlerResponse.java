package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand;

public class HandlerResponse {

    private StringBuffer stringBuffer;
    private String stylesheet;

    public HandlerResponse(StringBuffer stringBuffer, String stylesheet) {
        this.stringBuffer = stringBuffer;
        this.stylesheet = stylesheet;
    }
}
