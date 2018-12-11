package com.hepexta.refactoring.simplification.replacestatealteredwithstate;

public class SystemPermission {

    private SystemProfile profile;
    private SystemUser requestor;
    private SystemAdmin admin;
    private boolean isGranted;
    private String state;

    public final static String REQUESTED = "REQUESTED";
    public static final String UNIX_REQUESTED = "UNIX_REQUESTED";
    public static final String UNIX_CLAIMED = "UNIX_CLAIMED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    private boolean isUnixPermissionGranted;

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = REQUESTED;
        isGranted = false;
        notifyAdminOfPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        if (!state.equals(REQUESTED) && !state.equals(UNIX_REQUESTED))
            return;
        willBeHandledBy(admin);
        if (state.equals(REQUESTED))
            state = CLAIMED;
        else if (state.equals(UNIX_REQUESTED))
            state = UNIX_CLAIMED;
    }

    private void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    public void deniedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        isGranted = false;
        isUnixPermissionGranted = false;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        if (profile.isUnixPermissionRequired() && state.equals(UNIX_CLAIMED))
            isUnixPermissionGranted = true;
        else if (profile.isUnixPermissionRequired() &&
                !isUnixPermissionGranted()) {
            state = UNIX_REQUESTED;
            notifyUnixAdminsOfPermissionRequest();
            return;
        }
        state = GRANTED;
        isGranted = true;
        notifyUserOfPermissionRequestResult();
    }

    private boolean isUnixPermissionGranted() {
        return isUnixPermissionGranted;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public String state() {
        return state;
    }

    private void notifyAdminOfPermissionRequest() {
        System.out.println("notifyAdminOfPermissionRequest");
    }

    private void notifyUserOfPermissionRequestResult() {
        System.out.println("notifyUserOfPermissionRequestResult");
    }

    private void notifyUnixAdminsOfPermissionRequest() {
        System.out.println("notifyUnixAdminsOfPermissionRequest");
    }
}