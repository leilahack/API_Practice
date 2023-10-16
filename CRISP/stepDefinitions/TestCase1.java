package CRISP.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestCase1 {

    String APIEndpoint = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";


    /**
     * Scenario: Retrieve all patients from the API endpoint
     *
     * Given I have access to the API endpoint
     * And Accept header is “application/json”
     * When I send GET request
     * Then status code should be 200
     * And response content-type should be “application/json”
     * And following fields should not be null
     * | id |
     * | name|
     */

    @Test
    void testCase1(){

        /*for this task purposes I will store the test data (patient info) in Maps
        inside the testCase method for easier preview. Another option would be to store test data in a
        separate class (which I created under TestData) and then extend it in this class for reusability purposes.
        So the expected data of each client (given in the task) will be stored in Maps
         and then verified against the body response, which will be deserialized into same data structure.
         */

        Map<String, Object> patient0 = new LinkedHashMap<>();
        patient0.put("Id", "111");
        patient0.put("Name", "Jenn D.");
        patient0.put("DateOfBirth", "1934-06-01");
        patient0.put("Address", "CA");

        Map<String, Object> patient1 = new LinkedHashMap<>();
        patient1.put("Id", "222");
        patient1.put("Name", "Jack");
        patient1.put("DateOfBirth", "1956-05-01");
        patient1.put("Address", "MD");

        Map<String, Object> patient2 = new LinkedHashMap<>();
        patient2.put("Id", "333");
        patient2.put("Name", "Bernard");
        patient2.put("DateOfBirth", "1966-04-01");
        patient2.put("Address", "CA State");

        Map<String, Object> patient3 = new LinkedHashMap<>();
        patient3.put("Id", "444");
        patient3.put("Name", "Ross C.");
        patient3.put("DateOfBirth", "2000-03-01");
        patient3.put("Address", "Valley State");


        // Sending GET request
        /*I added a verification to check that the Id and Name entries are never left empty just to demonstrate one way
        to work with bigger amounts of data and in case I didn't have the expected results.
         */

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(APIEndpoint)
                .then().statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("Id", everyItem(notNullValue()))
                .body("Name", everyItem(notNullValue()))
                .extract().response();

        //Storing the response (all patient data) in a List of Maps

      List <Map<String, Object>> patientListOfMap = response.as(List.class);

        /*Accessing each patient and verifying the actual result against
        the expected result that we have previously stored in Map Objects with the correct data*/

        Assert.assertEquals(patient0, patientListOfMap.get(0));
        Assert.assertEquals(patient1, patientListOfMap.get(1));
        Assert.assertEquals(patient2, patientListOfMap.get(2));
        Assert.assertEquals(patient3, patientListOfMap.get(3));



    }


    }







