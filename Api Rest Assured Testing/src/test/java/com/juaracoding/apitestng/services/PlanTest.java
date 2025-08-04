package com.juaracoding.apitestng.services;

import com.juaracoding.apitestng.models.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlanTest {

    private GroupServices groupServices;
    private String token;

    @BeforeClass
    public void setUp() {
        groupServices = new GroupServices();
        token = "Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba";
    }

    @Test
    public void testGetAllGroups() {
        Group group = groupServices.all(token);
        Assert.assertEquals(group.getStatusCode(), 200, "Status code harus 200");
        Assert.assertNotNull(group.getId(), "Id group tidak boleh null");
        Assert.assertNotNull(group.getTitle(), "Title group tidak boleh null");
        Assert.assertNotNull(group.getOrigin(), "Origin group tidak boleh null");
    }

    @Test
    public void testGetGroupById() {
        int testId = 3; // Ganti dengan id group yang valid untuk pengujian
        Group group = groupServices.get(token, testId);
        Assert.assertEquals(group.getStatusCode(), 200, "Status code harus 200");
        Assert.assertEquals(group.getId(), String.valueOf(testId), "Id group harus sesuai dengan id yang diminta");
        Assert.assertNotNull(group.getTitle(), "Title group tidak boleh null");
        Assert.assertNotNull(group.getOrigin(), "Origin group tidak boleh null");
    }
}
