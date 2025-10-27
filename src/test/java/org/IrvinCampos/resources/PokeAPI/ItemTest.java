package org.IrvinCampos.resources.PokeAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ItemTest {

    @Test
    public void pokemonItemTest() {
        String response = given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("v2/item/1")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        int id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        System.out.println(id);
        System.out.println(name);
        Assert.assertEquals(id, 1);
    }
}
