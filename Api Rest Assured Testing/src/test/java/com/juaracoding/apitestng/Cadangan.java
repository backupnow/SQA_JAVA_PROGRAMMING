package com.juaracoding.apitestng;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;






public class Cadangan {

    @Test(enabled = false)
    public void tc0002() {
        // RestAssured.baseURI = BASE_URL;

        // use story
        // given sebagai developer/tester, gw pengen bisa mengakses product yang id nya
        // 2
        // when gw get /products/2
        // then gw mesti harus wajib kudu dapetin 200 dan ... sehingga gw tau kalo fitur
        // ini berjalan

        // acceptance criteria + tim dev + tim QA + product owner
        // - status harus 200
        // - produk dengan id 2 harus punya harga 90.3
        // - product dengan id 2 juga harus berkategroy men's clothing
        RestAssured.given()
                .when()
                .get("/products/2")
                .then()
                // acceptance criteria
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("category", CoreMatchers.equalTo("men's clothing"))
                .body("price", CoreMatchers.equalTo(90.3f));
    }


}
