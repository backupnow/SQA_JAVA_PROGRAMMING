package com.juaracoding.apitestng.services;




import com.juaracoding.apitestng.models.Group;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GroupServices {
    private RequestSpecification requestSpecification;
    private Response response;
    private Group group;
    private final String BASE_URL = "http://127.0.0.1:8000";

    public GroupServices() {
        RestAssured.baseURI = BASE_URL;
        requestSpecification = RestAssured.given();
        group = new Group();
    }

    public Group all(String token) {
        requestSpecification.header("Authorization", token);
        response = requestSpecification.get("/catalogs/groups/");
        group.setResponse(response);
        group.setJsonString();
        return group;
    }

    public void create() {
    }

    public Group get(String token, int id) {
        requestSpecification.header("Authorization", token);
        response = requestSpecification.get("/catalogs/groups/" + id + "/");
        group.setResponse(response);
        group.setJsonString();
        return group;
    }

    public void update(int id) {
    }

    public void remove(int id) {
    }
}
