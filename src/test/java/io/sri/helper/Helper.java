package io.sri.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    public static final String placePostData="maps/api/place/add/json";

    public static final String payLoad ="{\n" +
            "  \"location\": {\n" +
            "    \"lat\": -33.8669710,\n" +
            "    \"lng\": 151.1958750\n" +
            "  },\n" +
            "  \"accuracy\": 50,\n" +
            "  \"name\": \"Google Shoes!\",\n" +
            "  \"phone_number\": \"(02) 9374 4000\",\n" +
            "  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\n" +
            "  \"types\": [\"shoe_store\"],\n" +
            "  \"website\": \"http://www.google.com.au/\",\n" +
            "  \"language\": \"en-AU\"\n" +
            "}";

    public static String GenerateStringFormResource(String path) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    //Reusable Methods

    public static XmlPath rawToXML(Response r)
    {
        String response=r.asString();
        XmlPath xmlPath=new XmlPath(response);
        return xmlPath;
    }

    public static JsonPath rawJsonPath(Response r)
    {
        String response=r.asString();
        JsonPath jsonPath=new JsonPath(response);
        return jsonPath;
    }



}
