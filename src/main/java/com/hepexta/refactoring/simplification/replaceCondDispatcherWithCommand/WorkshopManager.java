package com.hepexta.refactoring.simplification.replaceCondDispatcherWithCommand;

import java.util.List;

public class WorkshopManager {
    private String nextWorkshopID;
    private String workshopDir;
    private String workshopTemplate;
    private List<StringBuffer> repository;

    public String getNextWorkshopID() {
        return nextWorkshopID;
    }

    public String getWorkshopDir() {
        return workshopDir;
    }

    public String getWorkshopTemplate() {
        return workshopTemplate;
    }

    public StringBuffer createNewFileFromTemplate(String nextWorkshopID, String workshopDir, String workshopTemplate) {
        StringBuffer stringBuffer = new StringBuffer(nextWorkshopID);
        return stringBuffer.append(workshopDir).append(workshopTemplate);
    }

    public void addWorkshop(StringBuffer newWorkshopContents) {
        repository.add(newWorkshopContents);
    }

    public List getWorkshopRepository() {
        return repository;
    }
}
