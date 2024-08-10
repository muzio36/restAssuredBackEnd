import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ApiTest {

    @Test
    public void test() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body : " + response.getBody().asPrettyString());
        System.out.println("Time: " + response.getTime());
        System.out.println("Header: " + response.header("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test2() {

        given().
                get("https://k08v1.wiremockapi.cloud").
                then().
                log().everything().
                statusCode(200);
    }
  /*  @Test
    public void test3() {
       // Response response = RestAssured.response("api.zippopotam.us");
        ValidatableResponse us = given().
                get("api.zippopotam.us").
                then().
                statusCode(200);
                //Assert.assertEquals(us.("places[0].'place name'"), ("Beverly Hills"));
    }*/
}

