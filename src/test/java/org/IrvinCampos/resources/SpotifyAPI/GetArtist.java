package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetArtist {

    @Test
    public void getArtistTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization", utils.get("spotifyToken"))
                .when().get("/v1/artists/0eDvMgVFoNV3TpwtrVCoTj")
                .then().statusCode(200).extract().asString();

        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("name");
        System.out.println(name);
        Assert.assertEquals(name, "Pop Smoke");
    }
}
