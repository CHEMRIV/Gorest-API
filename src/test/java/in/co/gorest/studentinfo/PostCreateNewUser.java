package in.co.gorest.studentinfo;

import in.co.gorest.model.PojoClass;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateNewUser extends TestBase {


    @Test
    public void createNewUser() {
        PojoClass studentPojo = new PojoClass();
        studentPojo.setName("John Potter");
        studentPojo.setEmail("johnPot"+getRandomValue()+"@gmail.com");
        studentPojo.setGender("male");
        studentPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 914c0f670f001278363480f4134d14f5dbf7d901652c1212fe3ce872e9e07d7b")
                .and()
                .body(studentPojo)
                .when()
                .post("/users")
                .then()
                .extract().response();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
