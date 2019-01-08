package com.hepexta.refactoring.protection.limitInstantiationWithSingleton;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.state.PermissionClaimed;

public class PermissionRequested extends Permission {
    public static final String NAME = "REQUESTED";

    public String name() {
        return NAME;
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandledBy(admin);
        permission.setState(new PermissionClaimed());
    }
}
