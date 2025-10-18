package task16;

//Make restAssured Test Cases using scenario from Task_15
//The same using any another API client.
//Add Request and Response clases for each unique endpoints.
//Validate Response Object using your own class comparator.

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class Task16Test {

    @BeforeTest
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void RestAssuredTest(){
        //Step 1
        String boardName = UUID.randomUUID().toString().substring(0,10);
        Response response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("name", boardName)
                .when()
                .post("https://api.trello.com/1/boards/?name={name}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.path("name"), boardName, "Unexpected board name");
        String boardId = response.path("id");

        //Step 2
        response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("boardId", boardId)
                .pathParam("list_name", UUID.randomUUID().toString().substring(0,10))
                .when()
                .post("https://api.trello.com/1/lists?name={list_name}&idBoard={boardId}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
}
