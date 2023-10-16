package CRISP.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class TestCase3 {

    // This is one of two ways that I automated this test case

    String APIEndpoint = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";

    /**
     * Given "Name" query parameter should be equal to "<Name>" TCThree
     *     And "DateOfBirth" query parameter should be equal to "<DateOfBirth>" TCThree
     *     And "Address" query parameter should be equal to "<Address>" TCThree
     *     When I send GET request TCThree
     *     Then status code should be 200 TCThree
     *     And response content-type should be "application/json" TCThree
     *     And payload must display patient data equal to expected data
     */

    @Test

    void testCase3(){

        Map<String, Object> patient0 = new LinkedHashMap<>();
        patient0.put("Id","111");
        patient0.put("Name","Jenn D.");
        patient0.put("DateOfBirth","1934-06-01");
        patient0.put("Address","CA");

        Map<String, Object> patient1 = new LinkedHashMap<>();
        patient1.put("Id","222");
        patient1.put("Name","Jack");
        patient1.put("DateOfBirth","1956-05-01");
        patient1.put("Address","MD");

        Map<String, Object> patient2 = new LinkedHashMap<>();
        patient2.put("Id","333");
        patient2.put("Name","Bernard");
        patient2.put("DateOfBirth","1966-04-01");
        patient2.put("Address","CA State");

        Map<String, Object> patient3 = new LinkedHashMap<>();
        patient3.put("Id","444");
        patient3.put("Name","Ross C.");
        patient3.put("DateOfBirth","2000-03-01");
        patient3.put("Address","Valley State");

        String queryParamID = "Id";
        String queryParamName = "Name";
        String queryParamDOB = "DateOfBirth";
        String queryParamAddress = "Address";


        JsonPath jsonPath = RestAssured
                .given().log().ifValidationFails()
                .accept(ContentType.JSON)
                .queryParam("Id", patient0.get("Id"))
                .queryParam("Name", patient0.get("Name"))
               .queryParam("DateOfBirth", patient0.get("DateOfBirth"))
                .queryParam("Address", patient0.get("Address"))
                .when()
                .get(APIEndpoint).prettyPeek()
                .then().statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("Id", everyItem(notNullValue()))
                .body("Name", everyItem(notNullValue()))
                .extract().jsonPath();






    }
}
