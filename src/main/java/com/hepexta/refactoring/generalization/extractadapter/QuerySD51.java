package com.hepexta.refactoring.generalization.extractadapter;

import com.hepexta.refactoring.generalization.extractadapter.ex.QueryException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDLoginFailedException;
import com.hepexta.refactoring.generalization.extractadapter.ex.SDSocketInitFailedException;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDLogin;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDQuery;
import com.hepexta.refactoring.generalization.extractadapter.sd.SDSession;

public class QuerySD51 extends AbstractQuery {

    private SDLogin sdLogin;
    private SDSession sdSession;

    public QuerySD51() {
        super();
    }

    // NOTE: remove this when we convert all aplications to 5.2
    public void login(String server, String user, String password) throws QueryException {
        try {
            sdSession = sdLogin.loginSession(server, user, password);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Login failure\n" + lfe, lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Socket fail\n" + ife, ife);
        }
    }

    public SDQuery getQuery() {
        return sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }
}
