package org.IrvinCampos;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListTest {

    @Test
    public void regresGetListTest() {
       String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).extract().response().asString();
       System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        int page = jsonPath.getInt("page");
        System.out.println(page);
    }
}
