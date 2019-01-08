package com.hepexta.refactoring.protection.limitInstantiationWithSingleton;

import org.junit.Assert;
import org.junit.Test;

public class PermissionTest {
    @Test
    public void testPermission() {
        Permission state = PermissionRequested.state();
        Assert.assertEquals("REQUESTED", state.name());
    }
}
