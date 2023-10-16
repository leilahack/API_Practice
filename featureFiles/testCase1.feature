Feature: HTTP GET Request - API 1

  @TC1

  Scenario: Retrieve all patients from the API endpoint
    Given I have access to the API endpoint
    And Accept header is “application/json”
    When I send GET request
    Then status code should be 200
    And response content-type should be “application/json”
    And “Id” and “Name” fields should not be null
    And actual patient data must match the expected results

    #Please run this test from the TestCase1 class in the stepDefinitions file.
  #void testCase1() method is runnable, but will fail due to a bug

