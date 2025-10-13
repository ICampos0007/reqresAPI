package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchTest {
    @Test
    public void spotifySearchTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization",utils.get("spotifyToken"))
                .queryParam("q", "drake")
                .queryParam("type", "artist")
                .when().get("/v1/search?q=drake&type=artist")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        List<String> names = jsonPath.getList("artists.items.name");
        System.out.println(names);
        List<String> getID = jsonPath.getList("artists.items.id");
        for (String id : getID) {
            System.out.println("Artist Id: " + id);
        }
        for (int i =0; i< names.size(); i++) {
            System.out.println(names.get(i) + " → " + getID.get(i));
        }

    }
}
