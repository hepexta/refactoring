package com.hepexta.refactoring.simplification.replacestatealteredwithstate.state;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;

public class PermissionClaimed extends PermissionState{
    public PermissionClaimed() {
        super("CLAIMED");
    }

    public void deniedBy(SystemAdmin admin, SystemPermission permission) {
        if (!permission.getAdmin().equals(admin))
            return;
        permission.setIsGranted(false);
        permission.setIsUnixPermissionGranted(false);
        permission.setState(DENIED);
        permission.notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin, SystemPermission permission) {
        if (!permission.getAdmin().equals(admin))
            return;
        if (permission.getProfile().isUnixPermissionRequired()
                && !permission.isUnixPermissionGranted()) {
            permission.setState(UNIX_REQUESTED);
            permission.notifyUnixAdminsOfPermissionRequest();
            return;
        }
        permission.setState(GRANTED);
        permission.setIsGranted(true);
        permission.notifyUserOfPermissionRequestResult();
    }
}
