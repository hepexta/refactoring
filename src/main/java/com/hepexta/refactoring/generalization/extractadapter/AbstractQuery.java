package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDQuery;

public abstract class AbstractQuery implements Query{

    protected SDQuery sdQuery; // this is needed for SD versions 5.1 & 5.2

    public void doQuery() throws QueryException {
        if (sdQuery != null)
            sdQuery.clearResultSet();
        sdQuery = getQuery();
        executeQuery();
    }

    abstract SDQuery getQuery();

    protected void executeQuery() {
        // Do Something.
    }
}
