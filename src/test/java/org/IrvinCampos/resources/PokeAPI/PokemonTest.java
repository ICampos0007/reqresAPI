package org.IrvinCampos.resources.PokeAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.annotations.Test;



public class PokemonTest {
    @Test
    public void getPOkemonTest() {
        String response = RestAssured.given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("/v2/pokemon/ditto")
                .then().statusCode(200).extract().asString();

        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("forms.name");
        System.out.println(name);

    }
}
