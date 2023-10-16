package CRISP.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestCase2 {

    // In this test case I am using parameterization and Scenario outline for id entries in order to avoid hardcoding.
    //So I can change the values or the query params in the feature file

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String APIEndpoint = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";

    @Given("Accept header is {string}")
    public void acceptHeaderIs(String contentType) {
        requestSpecification = RestAssured.given().accept(contentType);
    }

    //the query params here are pulled from the table in the feature file
    @And("{string} query parameter should be equal to {string}")
    public void queryParameterShouldBeEqualTo(String key, String value) {
        requestSpecification.queryParam(key, value);
    }


    @When("I send GET request a")
    public void i_send_get_requestA() {
       response = requestSpecification.when()
               .get(APIEndpoint)
               .prettyPeek();

       validatableResponse = response.then();
    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        validatableResponse.statusCode(statusCode);
    }

    @And("response content-type should be {string}")
    public void responseContentTypeShouldBe(String contentType) {

        validatableResponse.contentType(contentType);

    }

    @And("payload must display patient data equal to expected data")
    public void payloadMustDisplayPatientDataEqualToExpectedData() {

        // No payload in response

    }


}
