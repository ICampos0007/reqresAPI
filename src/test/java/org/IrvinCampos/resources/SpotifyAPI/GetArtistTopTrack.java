package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetArtistTopTrack {
    @Test
    public void getArtistTopTrackTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization",utils.get("spotifyToken"))
                .when().get("/v1/artists/3pc0bOVB5whxmD50W79wwO/top-tracks")
                .then().statusCode(200).extract().asString();

        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String tracks = jsonPath.getString("tracks");
        System.out.println(tracks);
    }
}
