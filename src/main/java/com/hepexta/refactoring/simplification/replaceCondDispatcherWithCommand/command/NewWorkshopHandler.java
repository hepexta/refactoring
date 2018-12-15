package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.HandlerResponse;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.WorkshopManager;

import java.util.Map;

public class NewWorkshopHandler {

    private CatalogApp catalogApp;
    private WorkshopManager workshopManager;

    public NewWorkshopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
        this.workshopManager = catalogApp.getWorkshopManager();
    }

    public HandlerResponse getNewWorkshopResponse(Map parameters) {
        createNewWorkShop(parameters);
        return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    }

    private void createNewWorkShop(Map parameters) {
        String nextWorkshopID = workshopManager.getNextWorkshopID();
        workshopManager.addWorkshop(newWorksopContent(nextWorkshopID));
        parameters.put("id", nextWorkshopID);
    }

    private StringBuffer newWorksopContent(String nextWorkshopID) {
        return workshopManager.createNewFileFromTemplate(
                nextWorkshopID,
                workshopManager.getWorkshopDir(),
                workshopManager.getWorkshopTemplate()
        );
    }
}
