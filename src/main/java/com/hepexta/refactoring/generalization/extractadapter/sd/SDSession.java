package com.hepexta.refactoring.generalization.extractadapter.sd;

public class SDSession {
    private String server;
    private String user;
    private String password;

    public SDSession(String server, String user, String password) {
        this.server = server;
        this.user = user;
        this.password = password;
    }

    public SDQuery createQuery(String query) {
        return new SDQuery(query);
    }
}
