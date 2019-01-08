package com.hepexta.refactoring.protection.limitInstantiationWithSingleton;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.state.PermissionClaimed;

public class PermissionRequested extends Permission {
    private static final String NAME = "REQUESTED";

    private PermissionRequested() {
    }

    private static Permission state = new PermissionRequested();

    public static Permission state() {
        return state;
    }

    public String name() {
        return NAME;
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandledBy(admin);
        permission.setState(new PermissionClaimed());
    }
}
