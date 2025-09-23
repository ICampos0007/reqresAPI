package org.IrvinCampos.resources;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateTest {

    @Test
    public void updateUserTest() {
        String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body("{\n" +
                        "  \"name\": \"morpheus\",\n" +
                        "  \"job\": \"zion resident\",\n" +
                        "  \"updatedAt\": \"2025-09-23T07:03:27.139Z\"\n" +
                        "}")
                .when().patch("/api/users/2")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
    }
}
