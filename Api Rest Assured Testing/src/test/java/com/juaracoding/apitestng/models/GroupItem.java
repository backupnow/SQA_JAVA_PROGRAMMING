package com.juaracoding.apitestng.models;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

public class GroupItem {

    Response response;
    String jsonString;

    public GroupItem(Response response) {
        setResponse(response);
        setJsonString();
    }

    public GroupItem() {
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public void setJsonString() {
        jsonString = response.asString();
    }

    public String getId() {
        return JsonPath.read(jsonString, "$.id").toString();
    }

    public String getName() {
        return JsonPath.read(jsonString, "$.name").toString();
    }

    public String getDescription() {
        return JsonPath.read(jsonString, "$.description").toString();
    }

    public String getGroupId() {
        return JsonPath.read(jsonString, "$.group.id").toString();
    }

    public String getGroupTitle() {
        return JsonPath.read(jsonString, "$.group.title").toString();
    }

    public String getGroupOrigin() {
        return JsonPath.read(jsonString, "$.group.origin").toString();
    }

    public int getStatusCode() {
        return response.statusCode();
    }
}
