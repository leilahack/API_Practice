package CRISP.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class NegativePath1 {

    // This is one of two ways that I automated this test case

    String negativeURI = "https://apimgmt-dev-crisp.azure-api.net/patients/";

    @Test
    void NegativeTestCase1(){

        Response response = RestAssured
                .given()
                .when()
                .get(negativeURI).prettyPeek()
                .then().statusCode(HttpStatus.SC_NOT_FOUND)
                .body("message", is("Resource not found"))
                .extract().response();

    }


}
