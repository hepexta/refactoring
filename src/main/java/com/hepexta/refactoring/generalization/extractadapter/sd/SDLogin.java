package com.hepexta.refactoring.generalization.extractadapter.sd;

import com.hepexta.refactoring.generalization.extractadapter.ex.SDLoginFailedException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDSocketInitFailedException;

public class SDLogin {
    private String server;
    private String user;
    private String password;

    public SDSession loginSession(String server, String user, String password) throws SDLoginFailedException, SDSocketInitFailedException {
        return new SDSession(server, user, password);
    }
}
