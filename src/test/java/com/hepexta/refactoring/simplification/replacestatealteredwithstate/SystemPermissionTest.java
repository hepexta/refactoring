package com.hepexta.refactoring.simplification.replacestatealteredwithstate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SystemPermissionTest {

    private SystemPermission permission;
    private SystemUser user = SystemUser.createUser();
    private SystemProfile profile = SystemProfile.createProfile();
    private SystemAdmin admin = SystemAdmin.createAdmin();

    @Before
    public void setUp() {
        permission = new SystemPermission(user, profile);
    }

    @Test
    public void testGrantedBy() {
        permission.grantedBy(admin);
        assertEquals("requested", SystemPermission.REQUESTED, permission.state());
        assertFalse("not granted", permission.isGranted());
        permission.claimedBy(admin);
        permission.grantedBy(admin);
        assertEquals("granted", SystemPermission.GRANTED, permission.state());
        assertTrue("granted", permission.isGranted());
    }

    @Test
    public void testDeniedBy() {
        permission.grantedBy(admin);
        assertEquals("requested", SystemPermission.REQUESTED, permission.state());
        assertFalse("not granted", permission.isGranted());
        permission.claimedBy(admin);
        permission.deniedBy(admin);
        assertEquals("granted", SystemPermission.DENIED, permission.state());
        assertFalse("granted", permission.isGranted());
    }
}