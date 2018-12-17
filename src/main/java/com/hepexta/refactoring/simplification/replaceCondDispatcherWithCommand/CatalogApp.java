package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand;

import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.AllWorkshopHandler;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.DefWorkshopHandler;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.Handler;
import com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand.command.NewWorkshopHandler;

import java.util.HashMap;
import java.util.Map;

public class CatalogApp {

    private static final String NEW_WORKSHOP = "NEW_WORKSHOP";
    public static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    private WorkshopManager workshopManager = new WorkshopManager();
    private Map<String, Handler> handlers;

    public CatalogApp() {
        createHandlers();
    }

    public void createHandlers() {
        handlers = new HashMap<>();
        handlers.put(NEW_WORKSHOP, new NewWorkshopHandler(this));
        handlers.put(ALL_WORKSHOPS, new AllWorkshopHandler(this));
        handlers.put(null, new DefWorkshopHandler(this));
    }

    public HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        return handlers.get(actionName).execute(parameters);
    }

    public WorkshopManager getWorkshopManager() {
        return workshopManager;
    }

}