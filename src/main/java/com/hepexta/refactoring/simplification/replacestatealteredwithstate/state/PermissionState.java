package com.hepexta.refactoring.simplification.replacestatealteredwithstate.state;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemAdmin;
import com.hepexta.refactoring.simplification.replacestatealteredwithstate.SystemPermission;

public abstract class PermissionState {
    private String name;

    public final static PermissionState REQUESTED = new PermissionRequested(); // FIXME Referencing to subclass can lead to deadlock
    public static final PermissionState UNIX_REQUESTED = new UnixPermissionRequested();
    public static final PermissionState UNIX_CLAIMED = new UnixPermissionClaimed();
    public final static PermissionState CLAIMED = new PermissionClaimed();
    public final static PermissionState GRANTED = new PermissionGranted();
    public final static PermissionState DENIED = new PermissionDenied();

    public PermissionState(String name) {
        this.name = name;
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {}
    public void deniedBy(SystemAdmin admin, SystemPermission permission) {}
    public void grantedBy(SystemAdmin admin, SystemPermission permission) {}
}
