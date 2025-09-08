package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login {

    @Test
    public void loginSuccessTest() {
        String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .when().post("/api/login")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("token");
        System.out.println(token);
        Assert.assertEquals(token,"QpwL5tke4Pnpja7X4");
    }
}
