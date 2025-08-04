package com.juaracoding.apitestng;

import com.jayway.jsonpath.JsonPath;
import com.juaracoding.apitestng.models.Group;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GroupTest {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String id;
    Group group;
    final String BASE_URL = "http://127.0.0.1:8000";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        // Buat request spec
        requestSpecification = RestAssured.given();

        requestSpecification.header("Authorization", "Token ea3e31f7ac64fb0ce4dbbfbc6661391c96dadeba");
        requestSpecification.header("Content-Type", "application/json");

        group = new Group();
    }

    @Test()
    public void tc0001() throws InterruptedException {
        Thread.sleep(2000);
        response = requestSpecification.get("/catalogs/groups/");

        validatableResponse = response.then();

        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

        String actualStatusLine = response.getStatusLine();
        String expectedStatusLine = "HTTP/1.1 200 OK";
        Assert.assertEquals(actualStatusLine, expectedStatusLine);
    }

    // buat no token
//    @Test()
//    public void tc0001NoToken() {
//        requestSpecification.header("Authorization", "Token 140b068ceef765c98edcd3386cb0c61e90eaf284");
//        response = requestSpecification.get("/catalogs/groups/");
//        validatableResponse = response.then();
//        int actualStatusCode = response.getStatusCode();
//
//    }

    @Test()
    public void tc0002() throws InterruptedException {
        Thread.sleep(2000);
        JSONObject payload = new JSONObject();

        payload.put("title", "Tempe");
        payload.put("origin", "Makan Gratis");

        requestSpecification.body(payload.toString());

        response = requestSpecification.post("/catalogs/groups/");

        group.setResponse(response);
        group.setJsonString();

        id = group.getId();

        int actualStatusCode = response.statusCode();
        int expectedStatusCode = 201;

        String actualTitle = group.getTitle();
        String expectedTitle = "Tempe";

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

    }

    @Test(enabled = true)
    public void tc0003() throws InterruptedException {
        Thread.sleep(2000);
        response = requestSpecification.get("/catalogs/groups/" + id + "/");

        group.setResponse(response);
        group.setJsonString();

        validatableResponse = response.then();

        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

        String actualStatusLine = response.getStatusLine();
        String expectedStatusLine = "HTTP/1.1 200 OK";
        Assert.assertEquals(actualStatusLine, expectedStatusLine);

        String actualTitle = group.getTitle();
        String expectedTitle = "Tempe";

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    // get all with token and bearer not token beareer (JWT)
    @Test()
    public void tc0004() throws InterruptedException {
        Thread.sleep(2000);
        JSONObject payload = new JSONObject();

        payload.put("title", "Tahu");
        payload.put("origin", "Makan Gratis Tapi Kok Aneh");

        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(payload.toString());

        response = requestSpecification.put("/catalogs/groups/" + id + "/");

        group.setResponse(response);
        group.setJsonString();

        Assert.assertEquals(group.getStatusCode(), 200);
        Assert.assertEquals(group.getTitle(), "Tahu");

    }

    // get all with invalid token
    @Test()
    public void tc0005() throws InterruptedException {
        Thread.sleep(2000);
        response = requestSpecification.delete("/catalogs/groups/" + id + "/");
        group.setResponse(response);
        group.setJsonString();

        Assert.assertEquals(group.getStatusCode(), 204);
    }
}
