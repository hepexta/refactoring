package com.hepexta.refactoring.protection.replaceTypeWithClass;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SystemPermissionTest {
    private SystemPermission permission;

    @Before
    public void setUp() {
        permission = new SystemPermission();
    }

    @Test
    public void testGrantedBy() {
        permission.granted();
        assertEquals("requested", PermissionState.REQUESTED, permission.getState());
        assertFalse("not granted", permission.isGranted());
        permission.claimed();
        permission.granted();
        assertEquals("granted", PermissionState.GRANTED, permission.getState());
        assertTrue("granted", permission.isGranted());
    }

    @Test
    public void testDeniedBy() {
        permission.granted();
        assertEquals("requested", PermissionState.REQUESTED, permission.getState());
        assertFalse("not granted", permission.isGranted());
        permission.claimed();
        permission.denied();
        assertEquals("granted", PermissionState.DENIED, permission.getState());
        assertFalse("granted", permission.isGranted());
    }
}
