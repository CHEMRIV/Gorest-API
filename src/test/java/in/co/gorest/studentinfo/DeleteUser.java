package in.co.gorest.studentinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser extends TestBase {


    @Test
    public void deleteSingleStudentInfo() {
        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 914c0f670f001278363480f4134d14f5dbf7d901652c1212fe3ce872e9e07d7b")
                .when()
                .delete("/users/3950")
                .then()
                .extract().response();
        response.then().statusCode(204);
        response.prettyPrint();

    }

}