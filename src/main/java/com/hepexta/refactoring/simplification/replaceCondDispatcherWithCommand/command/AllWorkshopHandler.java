package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.HandlerResponse;

import java.util.Iterator;

public class AllWorkshopHandler {
    private CatalogApp catalogApp;

    private static String ALL_WORKSHOPS_STYLESHEET = "allWorkshops.xsl";

    public AllWorkshopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }

    public HandlerResponse getAllWorkshopsResponse() {
        return new HandlerResponse(
                new StringBuffer(prettyPrint(allWorkshopsData())),
                ALL_WORKSHOPS_STYLESHEET
        );
    }

    private String allWorkshopsData() {
        StringBuilder allWorkshopsXml = new StringBuilder();
        Iterator ids = catalogApp.getWorkshopManager().getWorkshopRepository().iterator();
        while (ids.hasNext()) {
            allWorkshopsXml.append("workshop");
            allWorkshopsXml.append("id");
            allWorkshopsXml.append("name");
            allWorkshopsXml.append("status");
            allWorkshopsXml.append("duration");
        }
        return allWorkshopsXml.toString();
    }

    private String prettyPrint(String buffer) {
        return String.format(buffer);
    }
}
