Feature: HTTP GET Request - API 2

  @TC2
Scenario Outline: Retrieve one patient’s full data using only “Id” entry

Given Accept header is "application/json"
And "Id" query parameter should be equal to "<Id>"
When I send GET request a
Then status code should be 200
And response content-type should be "application/json"
 # And payload must display patient data equal to expected data

  Examples:
    | Id |
  |111 |
  |222 |
  |333 |
  |444 |


