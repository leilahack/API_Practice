Feature: Negative API testing GET request 1
@NTC1
  Scenario: Negative path creating a GET request with an invalid URI

    Given I have access to the API endpoint NTC
    When I send GET request to the wrong URI NTC
    Then status code should be 404 NTC
    And payload message should display "Resource not found" NTC
