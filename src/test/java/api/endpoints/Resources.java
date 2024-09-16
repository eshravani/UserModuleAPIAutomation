package api.endpoints;

import api.payloads.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Resources {
    public static Response createUser(User payLoad)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .body(payLoad)
                .when()
                .post(BaseUris.createUserPostUrl);
        return res;
    }

    public static Response getUser(String userName)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .when()
                .get(BaseUris.getUsersGetUrl);
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
                .put(BaseUris.updateUserUpdateUrl);
        return res;
    }

    public static Response deleteUser(String userName)
    {
        Response res = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .when()
                .delete(BaseUris.updateUserUpdateUrl);
        return res;
    }
}
