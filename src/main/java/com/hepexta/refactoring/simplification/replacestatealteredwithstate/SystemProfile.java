package com.hepexta.refactoring.simplification.replacestatealteredwithstate;

public class SystemProfile {
    private boolean unixPermission;

    private SystemProfile(boolean unixPermission) {
        this.unixPermission = unixPermission;
    }

    public static SystemProfile createProfile() {
        return new SystemProfile(false);
    }

    public static SystemProfile createUnixProfile() {
        return new SystemProfile(true);
    }

    public boolean isUnixPermissionRequired() {
        return unixPermission;
    }
}
