package com.juaracoding.apitestng.services;

import com.juaracoding.apitestng.models.GroupItem;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GroupItemServices {
    private RequestSpecification requestSpecification;
    private Response response;
    private GroupItem groupItem;
    private final String BASE_URL = "http://127.0.0.1:8000";

    public GroupItemServices() {
        RestAssured.baseURI = BASE_URL;
        requestSpecification = RestAssured.given();
        groupItem = new GroupItem();
    }

    public GroupItem all(String token) {
        requestSpecification.header("Authorization", token);
        response = requestSpecification.get("/catalogs/group-items/");
        response.prettyPrint(); // Tambahkan ini
        groupItem.setResponse(response);
        groupItem.setJsonString();
        return groupItem;
    }

    public GroupItem create(String token, String name, String description, int groupId) {
        requestSpecification.header("Authorization", token);
        requestSpecification.header("Content-Type", "application/json");
        
        String requestBody = String.format(
            "{\"name\": \"%s\", \"description\": \"%s\", \"group\": %d}",
            name, description, groupId
        );
        
        response = requestSpecification.body(requestBody).post("/catalogs/group-items/");
        groupItem.setResponse(response);
        groupItem.setJsonString();
        return groupItem;
    }

    public GroupItem get(String token, int id) {
        requestSpecification.header("Authorization", token);
        response = requestSpecification.get("/catalogs/group-items/" + id + "/");
        groupItem.setResponse(response);
        groupItem.setJsonString();
        return groupItem;
    }

    public void update(int id) {
    }

    public void remove(int id) {
    }
}
