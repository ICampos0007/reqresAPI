package org.IrvinCampos.resources.SpotifyAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    public void getUserTest() {
        String response = given().log().all().baseUri(utils.get("spotifyurl"))
                .header("Authorization",utils.get("spotifyToken"))
                .when().get("/v1/users/12174379475")
                .then().statusCode(200).extract().asString();
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        String displayName = jsonPath.getString("display_name");
        System.out.println(displayName);
        int totalFollowers = jsonPath.getInt("followers.total");
        System.out.println(totalFollowers);
        String image = jsonPath.getString("images.url");
        System.out.println(image);


    }
}
