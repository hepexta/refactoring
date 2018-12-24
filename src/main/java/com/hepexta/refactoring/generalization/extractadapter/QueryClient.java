package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;

public class QueryClient {
    private AbstractQuery query;

    public QueryClient() {
        setQueryVersion();
    }

    public void loginToDatabase(String db, String user, String password) {
        try {
            query.login(db, user, password);
            query.doQuery();
        } catch (QueryException qe){
            // Do Something.
        }
    }

    private void setQueryVersion() {
        if (usingSDVersion52()) {
            query = new QuerySD52(getSD52ConfigFileName());
        } else {
            query = new QuerySD51();
        }
    }

    private String getSD52ConfigFileName() {
        return "SD52ConfigFile";
    }

    private boolean usingSDVersion52() {
        return false;
    }
}
