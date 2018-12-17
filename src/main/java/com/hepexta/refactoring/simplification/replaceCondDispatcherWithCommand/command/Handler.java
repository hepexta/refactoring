package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.HandlerResponse;

import java.util.Map;

public abstract class Handler {
    protected CatalogApp catalogApp;

    public Handler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }

    public abstract HandlerResponse execute(Map parameters);
}
