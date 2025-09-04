package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SingleResource {

    @Test
    public void singleResourceTest() {
       String response = given().log().all().baseUri(utils.get("baseURL"))
                .header("Content-Type","application/json")
                .header("x-api-key", utils.get("apiKey"))
                .body("{\n" +
                        "    \"data\": {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"fuchsia rose\",\n" +
                        "        \"year\": 2001,\n" +
                        "        \"color\": \"#C74375\",\n" +
                        "        \"pantone_value\": \"17-2031\"\n" +
                        "    },\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "    }\n" +
                        "}")
                .when().get("/api/unknown/2")
                .then().statusCode(200).extract().asString();
       System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String year = jsonPath.getString("data.year");
        String text = jsonPath.getString("support.text");
        System.out.println(year);
        System.out.println(text);
    }
}
