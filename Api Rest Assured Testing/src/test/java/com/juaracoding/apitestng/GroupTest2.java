package com.juaracoding.apitestng;




import com.juaracoding.apitestng.models.Group;
import com.juaracoding.apitestng.services.GroupServices;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest2 {

    // gett all
    @Test()
    public void tc0001() throws InterruptedException {
        Thread.sleep(2000);
        GroupServices service = new GroupServices();
        Group groupTest1 = service.all("Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba");
        Assert.assertEquals(groupTest1.getStatusCode(), 200);
    }

    //not token
    @Test()
    public void tc0002() throws InterruptedException {
        Thread.sleep(2000);
        GroupServices service = new GroupServices();
        Group groupTest1 = service.all("");
        Assert.assertEquals(groupTest1.getStatusCode(), 401);
    }

    // get all with token without bereer
    @Test()
    public void tc0003() throws InterruptedException {
        Thread.sleep(2000);
        GroupServices service = new GroupServices();
        Group group = service.get("Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba", 3);
        Assert.assertEquals(group.getStatusCode(), 200);
    }
}
