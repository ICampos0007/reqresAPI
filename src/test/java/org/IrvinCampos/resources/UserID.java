package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserID {

    @Test
    public void getUserIDTest() {
        String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .when().get("https://reqres.in/api/users/7")
                .then().statusCode(200).extract().asString();

        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);
        int id = jsonPath.getInt("data.id");
        System.out.println(id);

//        fail the user ID Test

        String response2 = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .when().get("https://reqres.in/api/users/rasf")
                .then().statusCode(404).extract().asString();
        System.out.println(response2);
    }
}
