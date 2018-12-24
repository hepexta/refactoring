package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;

public interface Query {
    void doQuery() throws QueryException;
    void login(String server, String user, String password) throws QueryException;
}
