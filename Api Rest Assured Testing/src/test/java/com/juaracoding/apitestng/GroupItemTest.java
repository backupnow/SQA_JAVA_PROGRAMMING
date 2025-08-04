package com.juaracoding.apitestng;

import com.juaracoding.apitestng.models.GroupItem;
import com.juaracoding.apitestng.services.GroupItemServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupItemTest {

    // GET Get Group Items - success with valid token
    @Test()
    public void tc0004() throws InterruptedException {
        Thread.sleep(2000);
        GroupItemServices service = new GroupItemServices();
        GroupItem groupItem = service.all("Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba");
        Assert.assertEquals(groupItem.getStatusCode(), 200);
    }

    // POST Create Group Item - success with valid data
    @Test()
    public void tc0005() throws InterruptedException {
        Thread.sleep(2000);
        GroupItemServices service = new GroupItemServices();
        GroupItem groupItem = service.create(
            "Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba",
            "Mobil Supra MK4",
            "Drifting",
            6
        );
        Assert.assertEquals(groupItem.getStatusCode(), 201);
    }

    // GET Get Group Item by ID - success with valid token
    @Test()
    public void tc0006() throws InterruptedException {
        Thread.sleep(2000);
        GroupItemServices service = new GroupItemServices();
        GroupItem groupItem = service.get("Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba", 1);
        Assert.assertEquals(groupItem.getStatusCode(), 200);
    }
}
