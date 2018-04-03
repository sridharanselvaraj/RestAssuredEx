package io.sri.JiraApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;
import static io.sri.helper.Helper.rawJsonPath;

public class JiraApiEx1 {

    Properties pro=new Properties();

    @BeforeTest
    public void fileEx() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\admin\\IdeaProjects\\RestAssuredEx\\src\\resources\\env.properties");
        pro.load(fileInputStream);
    }

    // Post Example

    public String JiraAPIgetSessionKey()
    {
        //Create Session
        //http://localhost:9009/rest/auth/1/session

        RestAssured.baseURI=pro.getProperty("JiraHost");

        Response response= given().header("Content-Type","application/json").
                body("{ \"username\": \"admin\", \"password\": \"1234\" }").
                when().
                post("rest/auth/1/session").then().statusCode(200).
                extract().response();

        JsonPath js =rawJsonPath(response);
        String session=js.get("session.value");
        System.out.println("Session Value :"+session);
        return sessionId;

    }

    @Test
    public void JiraApiCreateIssuesandDefect()
    {
        RestAssured.baseURI=pro.getProperty("JiraHost");
        Response res=given().header("Content-Type","application/json").
                header("Cookie","JSESSIONID="+JiraAPIgetSessionKey()).
                body("{\n" +
                        "\n" +
                        "\"fields\":{\n" +
                        "\t\"project\":\n" +
                        "\t{\n" +
                        "\t\t\"key\":\"RES\"\n" +
                        "\t},\n" +
                        "\t\"summary\": \"Defect:JIRA REST Example Test.\",\n" +
                        "\t\"description\": \"As a QA, I have found the defect in Jira API,Which is refreshing incorrectly\",\n" +
                        "\t\"issuetype\":{\n" +
                        "\t\t\"name\": \"Bug\"\n" +
                        "\t}\n" +
                        "\t}\n" +
                        "}").
                when().post("rest/api/2/issue/").then().statusCode(201).extract().response();

            JsonPath js =rawJsonPath(res);
            String id=js.get("id");
        System.out.println("ID :"+id);
    }

}
