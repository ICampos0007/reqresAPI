package org.IrvinCampos.resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utils {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("C://Users//Irvin//Desktop//reqresApi//src//test//java//org//IrvinCampos//resources//global.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties file");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public String getJSonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.get(key);
    }
}
