package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getAlbum {

    @Test
    public void getAlbumTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization",utils.get("spotifyToken"))
                .when().get("/v1/albums/7C8uqokvE67UOlu1TiEYMd")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("name");
        System.out.println(name);
    }
}
