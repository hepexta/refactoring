package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.HandlerResponse;

import java.util.Map;

import static com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp.ALL_WORKSHOPS;

public class DefWorkshopHandler extends Handler {

    public DefWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    public HandlerResponse execute(Map parameters) {
        HandlerResponse response;
        response = new HandlerResponse(
                new StringBuffer(),
                ALL_WORKSHOPS
        );
        return response;
    }

}
