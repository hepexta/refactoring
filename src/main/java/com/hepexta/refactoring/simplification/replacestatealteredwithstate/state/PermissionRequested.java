package com.hepexta.refactoring.simplification.replacestatealteredwithstate.state;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;

public class PermissionRequested extends PermissionState{
    public PermissionRequested() {
        super("REQUESTED");
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandledBy(admin);
        permission.setState(CLAIMED);
    }
}
