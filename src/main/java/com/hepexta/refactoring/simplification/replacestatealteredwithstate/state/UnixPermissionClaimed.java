package com.hepexta.refactoring.simplification.replacestatealteredwithstate.state;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;

public class UnixPermissionClaimed extends PermissionState{
    public UnixPermissionClaimed() {
        super("UNIX_CLAIMED");
    }

    public void grantedBy(SystemAdmin admin, SystemPermission permission) {
        if (!permission.getAdmin().equals(admin))
            return;
        permission.setState(GRANTED);
        permission.setIsGranted(true);
        permission.notifyUserOfPermissionRequestResult();
    }
}
