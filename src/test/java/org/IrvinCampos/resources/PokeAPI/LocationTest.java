package org.IrvinCampos.resources.PokeAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LocationTest {
    @Test
    public void pokemonLocationTest() {
        String response = given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("v2/location/sinnoh")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("name");
        System.out.println(name);
    }
}
