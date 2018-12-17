package com.hepexta.refactoring.simplification.replacestatealteredwithstate.state;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;

public class UnixPermissionRequested extends PermissionState{
    public UnixPermissionRequested() {
        super("UNIX_REQUESTED");
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        permission.willBeHandledBy(admin);
        permission.setState(UNIX_CLAIMED);
    }
}
