package org.IrvinCampos.resources.PokeAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EvolutionTest {
    @Test
    public void pokemonEvolutionTest() {
        String response = given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("v2/evolution-chain/2")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        int id = jsonPath.getInt("id");
        System.out.println(id);
    }
}
