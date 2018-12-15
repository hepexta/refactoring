package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand;

import java.util.Iterator;
import java.util.Map;

public class CatalogApp {

    private static final String NEW_WORKSHOP = "NEW_WORKSHOP";
    private static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    private static final String ALL_WORKSHOPS_STYLESHEET = "ALL_WORKSHOPS_STYLESHEET";
    private WorkshopManager workshopManager = new WorkshopManager();

    private HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        HandlerResponse response;
        if (actionName.equals(NEW_WORKSHOP)) {
            response = getNewWorkshopResponse(parameters);
        } else if (actionName.equals(ALL_WORKSHOPS)) {
            response = getAllWorkshopsResponse();
        }
        else {
            response = getDefaultHandlerResponse();
        }
        return response;
    }

    private HandlerResponse getDefaultHandlerResponse() {
        HandlerResponse response;
        response = new HandlerResponse(
                new StringBuffer(),
                ALL_WORKSHOPS
        );
        return response;
    }

    private HandlerResponse getAllWorkshopsResponse() {
        HandlerResponse response;
        StringBuilder allWorkshopsXml = new StringBuilder();
        Iterator ids = workshopManager.getWorkshopRepository().iterator();
        while (ids.hasNext()) {
            allWorkshopsXml.append("workshop");
            allWorkshopsXml.append("id");
            allWorkshopsXml.append("name");
            allWorkshopsXml.append("status");
            allWorkshopsXml.append("duration");
        }
        String formattedXml = getFormattedData(allWorkshopsXml.toString());
        response = new HandlerResponse(
                new StringBuffer(formattedXml),
                ALL_WORKSHOPS_STYLESHEET
        );
        return response;
    }

    private HandlerResponse getNewWorkshopResponse(Map parameters) {
        String nextWorkshopID = workshopManager.getNextWorkshopID();
        StringBuffer newWorkshopContents =
                workshopManager.createNewFileFromTemplate(
                        nextWorkshopID,
                        workshopManager.getWorkshopDir(),
                        workshopManager.getWorkshopTemplate()
                );
        workshopManager.addWorkshop(newWorkshopContents);
        parameters.put("id", nextWorkshopID);
        return executeActionAndGetResponse(ALL_WORKSHOPS, parameters);
    }

    private String getFormattedData(String s) {
        return s;
    }
}