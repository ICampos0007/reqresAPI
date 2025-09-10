package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterSuccesful {

    @Test
    public void registerSuccesfulTest() {
        String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when().post("/api/register")
                .then().statusCode(200).extract().asString();
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);
        String email = jsonPath.getString("email");
        String password = jsonPath.getString("password");
        System.out.println(email);
        System.out.println(password);

//        register unsuccessful

        String response2 = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}")
                .when().post("/api/register")
                .then().statusCode(400).extract().asString();
        System.out.println(response2);
        JsonPath jsonPath2 = new JsonPath(response2);
        String error = jsonPath2.getString("error");
        System.out.println(error);
    }
}
