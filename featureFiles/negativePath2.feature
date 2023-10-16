Feature: Negative API testing GET request 2
@NTC2
  Scenario Outline: Negative path creating a GET request with invalid query parameters
    Given I have access to the API endpoint
    And the field value for "DateOfBirth" query param is equal to "<DateOfBirth>"
    And the field value for "Address" query param is equal to "<Address>"
    When I send GET request
    Then status code needs to be 400
    And payload message should display "Bad Request"
    Examples:
      | DateOfBirth | Address      |
      | 1934-06-02  | CA           |
      | 1956-05-02  | MD           |
      | 1966-04-02  | CA State     |
      | 2000-03-02  | Valley State |

  #These DOBs are invalid, the day is wrong in all of them

