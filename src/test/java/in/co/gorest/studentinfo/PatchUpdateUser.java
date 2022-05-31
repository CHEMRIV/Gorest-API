package in.co.gorest.studentinfo;

import in.co.gorest.model.PojoClass;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUpdateUser extends TestBase {


    @Test
    public void createNewUser() {

        PojoClass studentPojo = new PojoClass();
        studentPojo.setName("Richard Pillar");
        studentPojo.setEmail("richard"+getRandomValue()+"@gmail.com");
        studentPojo.setStatus("active");
        studentPojo.setGender("male");


        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 914c0f670f001278363480f4134d14f5dbf7d901652c1212fe3ce872e9e07d7b")
                .pathParams("id",3970)
                .and()
                .body(studentPojo)
                .when()
               // .patch("/users/3970")
                .patch("/users"+"/{id}")
                .then()
                .extract().response();
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
