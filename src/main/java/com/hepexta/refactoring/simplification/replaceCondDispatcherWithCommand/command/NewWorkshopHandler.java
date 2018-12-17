package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.CatalogApp;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.HandlerResponse;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.WorkshopManager;

import java.util.Map;

public class NewWorkshopHandler extends Handler {

    public NewWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    public HandlerResponse execute(Map parameters) {
        createNewWorkShop(parameters);
        return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    }

    private void createNewWorkShop(Map parameters) {
        WorkshopManager workshopManager = catalogApp.getWorkshopManager();
        String nextWorkshopID = workshopManager.getNextWorkshopID();
        workshopManager.addWorkshop(newWorksopContent(workshopManager, nextWorkshopID));
        parameters.put("id", nextWorkshopID);
    }

    private StringBuffer newWorksopContent(WorkshopManager workshopManager, String nextWorkshopID) {
        return workshopManager.createNewFileFromTemplate(
                nextWorkshopID,
                workshopManager.getWorkshopDir(),
                workshopManager.getWorkshopTemplate()
        );
    }
}
