package com.hepexta.refactoring.simplification.replacestatealteredwithstate;

import com.hepexta.refactoring.simplification.replacestatealteredwithstate.state.PermissionState;

public class SystemPermission {

    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private boolean isGranted;
    private PermissionState state;

    private boolean isUnixPermissionGranted;

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = PermissionState.REQUESTED;
        isGranted = false;
        notifyAdminOfPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        state.claimedBy(admin, this);
    }

    public void deniedBy(SystemAdmin admin) {
        state.deniedBy(admin, this);
    }

    public void grantedBy(SystemAdmin admin) {
        state.grantedBy(admin, this);
    }

    public void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    public boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public PermissionState state() {
        return state;
    }

    private void notifyAdminOfPermissionRequest() {
        System.out.println("notifyAdminOfPermissionRequest");
    }

    public void notifyUserOfPermissionRequestResult() {
        System.out.println("notifyUserOfPermissionRequestResult");
    }

    public void notifyUnixAdminsOfPermissionRequest() {
        System.out.println("notifyUnixAdminsOfPermissionRequest");
    }

    public void setState(PermissionState state) {
        this.state = state;
    }

    public SystemAdmin getAdmin() {
        return this.admin;
    }

    public void setIsGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }

    public void setIsUnixPermissionGranted(boolean isUnixPermissionGranted) {
        this.isUnixPermissionGranted = isUnixPermissionGranted;
    }

    public SystemProfile getProfile() {
        return this.profile;
    }
}