package io.sri.GoogleMapapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.sri.helper.Helper.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiPostJsonEx1 {

    //https://developers.google.com/places/web-service/add-place
    Properties properties=new Properties();

    @BeforeTest
    public void getData()
    {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\RestAssuredEx\\src\\resources\\env.properties");
            properties.load(fileInputStream);
        }catch (Exception e) {
            e.getMessage();
        }
    }



    @Test
    public void postData()
    {

        //Task1 : Grap the Response = response(place id)
        RestAssured.baseURI = properties.getProperty("HOST");
        Response res= given().
                queryParam("key",properties.getProperty("KEY")).
                body(payLoad)
                .when()
                .post(placePostData).then()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
                .body("status",equalTo("OK")).
                extract().response();

        //Task2 : Grap the Place Id from response
        JsonPath js= rawJsonPath(res);
         // convert the plain text to json format
        String placeId =js.get("place_id");
        System.out.println(placeId);

        //Create a place = response(place id) and delete place = (place id)

        //Task3 : place this place id in the Delete request
        given().
                queryParam("key",properties.getProperty("KEY")).
                body("{\n" +
                        "  \"place_id\": \""+placeId+"\"\n" +
                        "}").
                when().
                post("maps/api/place/delete/json").then()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
                .body("status",equalTo("OK"));


    }
}
