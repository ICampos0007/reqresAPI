package org.IrvinCampos.resources.PokeAPI;

import io.restassured.path.json.JsonPath;
import org.IrvinCampos.resources.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BerryTest {
    @Test
    public void pokemonBerryTest() {
        String response = given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("v2/berry-flavor/1")
                .then().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        int id = jsonPath.getInt("id");
        System.out.println(id);
        Assert.assertEquals(id, 1);

//        now getting a berry by its name


        String response2 = given().log().all().baseUri(utils.get("pokeApiurl"))
                .when().get("v2/berry/cheri")
                .then().statusCode(200).extract().asString();
        System.out.println(response2);
        JsonPath jsonPath2 = new JsonPath(response2);
        String name = jsonPath2.getString("name");
        System.out.println(name);

    }
}
