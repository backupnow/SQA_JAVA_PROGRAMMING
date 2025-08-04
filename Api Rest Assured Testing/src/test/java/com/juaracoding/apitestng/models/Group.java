package com.juaracoding.apitestng.models;




import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

public class Group {

    Response response;
    String jsonString;

    public Group(Response response) {
        setResponse(response);
        setJsonString();
    }

    public Group() {
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

    public String getTitle() {
        return JsonPath.read(jsonString, "$.title").toString();
    }

    public String getOrigin() {
        return JsonPath.read(jsonString, "$.origin").toString();
    }

    public Object getJSONObject() {
        return JsonPath.read(jsonString, "$.").toString();
    }

    public int getStatusCode() {
        return response.statusCode();
    }
}
