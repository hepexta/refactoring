package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;

public class QueryClient {
    private Query query;

    public void loginToDatabase(String db, String user, String password) {
        query = new Query();
        try {
            if (usingSDVersion52()) {
                query.login(db, user, password, getSD52ConfigFileName());  // Login to SD 5.2
            } else {
                query.login(db, user, password); // Login to SD 5.1
            }
        } catch (QueryException qe){
            // Do Something.
        }
    }

    private String getSD52ConfigFileName() {
        return "SD52ConfigFile";
    }

    private boolean usingSDVersion52() {
        return false;
    }
}
