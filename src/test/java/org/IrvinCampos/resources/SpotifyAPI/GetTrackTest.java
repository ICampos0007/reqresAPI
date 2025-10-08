package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetTrackTest {
    @Test
    public void getSpotifyTrackTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization",utils.get("spotifyToken"))
                .when().get("/v1/tracks/5SlU0Yhi51jobhEiGE4xDv")
                .then().statusCode(200).extract().asString();
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("album.name");
        System.out.println(name);
        Assert.assertEquals("2 soon",name);
    }
}
