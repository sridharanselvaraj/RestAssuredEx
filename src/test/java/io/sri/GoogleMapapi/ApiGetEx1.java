package io.sri.GoogleMapapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiGetEx1 {

    @Test
    public void Test() {

        RestAssured.baseURI = "https://maps.googleapis.com";

        //  https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=48.859294,2.347589&radius=5000&type=cafe&keyword=vegetarian&key=AIzaSyCgMl28HZ4AZNeyGjMYx-abTW0_XOC44ZM

        given().
                param("location", "48.859294,2.347589")
                .param("radius", "5000")
                .param("key", "AIzaSyCgMl28HZ4AZNeyGjMYx-abTW0_XOC44ZM")
                .when()
                .get("/maps/api/place/nearbysearch/json")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
                //.body("results[0].geometry.location.lat",equalTo("48.865673"));
                .body("results[0].name", equalTo("Paris")).and()
                .header("server","scaffolding on HTTPServer2");

    }
}
