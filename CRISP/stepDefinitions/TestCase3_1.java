package CRISP.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import java.util.List;

import static io.restassured.RestAssured.given;

public class TestCase3_1 {

    // In this test case I am using parameterization and Scenario outline for query params to avoid hardcoding.
    //So I can change the values or the query params in the table in the feature file

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String APIEndpoint = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";



    @Given("Id query params are used with following values")
    public void idQueryParamsAreUsedWithFollowingValues(List<String> IDs) {
        requestSpecification = given().log().ifValidationFails()
                .accept(ContentType.JSON)
                .queryParam("Id", IDs.get(0))
                .queryParam("Id", IDs.get(1))
                .queryParam("Id", IDs.get(2))
                .queryParam("Id", IDs.get(3));

    }

    @And("Name query params are used with following values")
    public void nameQueryParamsAreUsedWithFollowingValues(List <String> Names) {
        requestSpecification.queryParam("Name",Names.get(0) )
                            .queryParam("Name",Names.get(1) )
                            .queryParam("Name",Names.get(2) )
                            .queryParam("Name",Names.get(3) );


    }

    @And("DateOfBirth query params are used with following values")
    public void dateofbirthQueryParamsAreUsedWithFollowingValues(List <String> DOBs) {
        requestSpecification.queryParam("DateOfBirth",DOBs.get(0) )
                            .queryParam("DateOfBirth",DOBs.get(1) )
                            .queryParam("DateOfBirth",DOBs.get(2) )
                            .queryParam("DateOfBirth",DOBs.get(3) );
    }

    @And("Address query params are used with following values")
    public void addressQueryParamsAreUsedWithFollowingValues(List <String> Address) {
        requestSpecification.queryParam("Address",Address.get(0) )
                            .queryParam("Address",Address.get(1) )
                            .queryParam("Address",Address.get(2) )
                            .queryParam("Address",Address.get(3) );

    }
    @When("I send GET request TCThree")
    public void i_send_get_request_tc_three() {
        response = requestSpecification.when()
                .get(APIEndpoint)
                .prettyPeek();

        validatableResponse = response.then();
    }
    @Then("status code should be {int} TCThree")
    public void status_code_should_be_tc_three(Integer int1) {
        validatableResponse.statusCode(200);

    }
    @Then("response content-type should be {string} TCThree")
    public void response_content_type_should_be_tc_three(String string) {
        validatableResponse.contentType(string);
    }



}
