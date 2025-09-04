package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @Test
    public void CreateUserReqresTest() {
        String requestBody = "{\n" +
                "  \"name\": \"Cozy\",\n" +
                "  \"job\": \"King\"\n" +
                "}";
       String response =  given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body(requestBody)
                .when().post("/api/users")
                .then().statusCode(201).extract().asString();

       System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("name");
        Assert.assertEquals("Cozy",name);
    }
}
