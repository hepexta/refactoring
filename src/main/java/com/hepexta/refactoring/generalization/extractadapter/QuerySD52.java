package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDLoginFailedException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDNotFoundException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDSocketInitFailedException;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDLoginSession;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDQuery;

public class QuerySD52 extends AbstractQuery {

    private SDLoginSession sdLoginSession;
    private String sdConfigFileName;

    public QuerySD52(String sdConfigFileName) {
        super();
        this.sdConfigFileName = sdConfigFileName;
    }

    public void login(String server, String user, String password) throws QueryException {
        sdLoginSession = new SDLoginSession(sdConfigFileName, false);
        try {
            sdLoginSession.loginSession(server, user, password);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Login failure\n" + lfe, lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Socket fail\n" + ife, ife);
        } catch (SDNotFoundException nfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Not found exception\n" + nfe, nfe);
        }
    }

    public SDQuery getQuery() {
        return sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }
}
