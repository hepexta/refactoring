package com.hepexta.refactoring.generalization.extractadapter.sd;

import com.hepexta.refactoring.generalization.extractadapter.ex.SDLoginFailedException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDNotFoundException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDSocketInitFailedException;

public class SDLoginSession {
    public SDLoginSession(String sdConfigFileName, boolean flag) {
        // Do something
    }

    public void loginSession(String server, String user, String password) throws SDLoginFailedException, SDSocketInitFailedException, SDNotFoundException {
        // Do something
    }

    public SDQuery createQuery(String query) {
        return new SDQuery(query);
    }
}
