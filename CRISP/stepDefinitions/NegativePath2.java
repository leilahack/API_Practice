package CRISP.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NegativePath2 {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String APIEndpoint = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";

    @Given("I have access to the API endpoint")
    public void iHaveAccessToTheAPIEndpoint() {
    }
    @Given("the field value for {string} query param is equal to {string}")
    public void the_field_value_for_query_param_is_equal_to(String key, String value) {
        requestSpecification = RestAssured.given().accept(ContentType.JSON)
                .queryParam(key, value);


    }
    @When("I send GET request")
    public void i_send_get_request() {
        response = requestSpecification.when()
                .get(APIEndpoint)
                .prettyPeek();

        validatableResponse = response.then();
    }
    @Then("status code needs to be {int}")
    public void status_code_needs_to_be(Integer statusCode) {
        validatableResponse.statusCode(statusCode);
    }
    @Then("payload message should display {string}")
    public void payload_message_should_display(String string) {

    }


}
