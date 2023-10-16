package CRISP.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class NegativePath1_1 {

    // This is one of two ways that I automated this test case

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String invalidURI = "https://apimgmt-dev-crisp.azure-api.net/patients/";

    @Given("I have access to the API endpoint NTC")
    public void iHaveAccessToTheAPIEndpointNTC() {
        requestSpecification = RestAssured.given().accept(ContentType.JSON);
    }

    @When("I send GET request to the wrong URI NTC")
    public void iSendGETRequestNTC() {
        response = requestSpecification.when()
                .get(invalidURI)
                .prettyPeek();

        validatableResponse = response.then();
    }

    @Then("status code should be {int} NTC")
    public void statusCodeShouldBeNTC(int statusCode) {
        validatableResponse.statusCode(statusCode);
    }

    @And("payload message should display {string} NTC")
    public void payloadMessageShouldDisplayNTC(String message) {
        validatableResponse.body("message", is(message));
    }
}
