package io.sri.GoogleMapapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.sri.helper.Helper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

import static io.sri.helper.Helper.rawToXML;

public class ApiPostXmlEx {

    Properties properties=new Properties();
    String postXmlData= Helper.GenerateStringFormResource("C:\\Users\\admin\\IdeaProjects\\RestAssuredEx\\src\\resources\\postXMLData.xml");

    public ApiPostXmlEx() throws IOException {
    }

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
                body(postXmlData)
                .when()
                .post("maps/api/place/add/xml").then()
                .assertThat().statusCode(200).and().contentType(ContentType.XML).and().
                        extract().response();

        //Task2 : Grap the Place Id from response (xml format)

        XmlPath xmlPath= rawToXML(res);
        String x = xmlPath.get("PlaceAddResponse.place_id");
        System.out.println(x);



    }

}
