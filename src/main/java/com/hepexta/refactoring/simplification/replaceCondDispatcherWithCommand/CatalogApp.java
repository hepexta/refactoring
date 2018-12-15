package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.AllWorkshopHandler;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.DefWorkshopHandler;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.NewWorkshopHandler;

import java.util.Map;

public class CatalogApp {

    private static final String NEW_WORKSHOP = "NEW_WORKSHOP";
    public static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    private WorkshopManager workshopManager = new WorkshopManager();

    public HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        if (actionName.equals(NEW_WORKSHOP)) {
            return new NewWorkshopHandler(this).getNewWorkshopResponse(parameters);
        } else if (actionName.equals(ALL_WORKSHOPS)) {
            return new AllWorkshopHandler(this).getAllWorkshopsResponse();
        }
        else {
            return new DefWorkshopHandler().getNewWorkshopResponse(parameters);
        }
    }

    public WorkshopManager getWorkshopManager() {
        return workshopManager;
    }

}