package api.endpoints;

import api.payloads.User;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ResourcesEndPoints {

    public static String getUrls(String properyName) {
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(".//src//test//resources//urls.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(properyName);
    }

    public static Response createUser(User payLoad) {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .body(payLoad)
                .when()
                .post(getUrls("create_user_url"));
        return res;
    }

    public static Response getUser(String userName)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .when()
                .get(getUrls("get_user_url"));
        return res;
    }

    public static Response updateUser(User payLoad,String userName)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .body(payLoad)
                .when()
                .put(getUrls("update_user_url"));
        return res;
    }

    public static Response deleteUser(String userName)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .when()
                .delete(getUrls("delete_user_url"));
        return res;
    }
}
