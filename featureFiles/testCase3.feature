Feature: HTTP GET Request - API 3
  @TC3
  Scenario:

   Given Id query params are used with following values

     | 111 |
     | 222 |
     | 333 |
     | 444 |

    And Name query params are used with following values

      | Jenn D. |
      | Jack    |
      | Bernard |
      | Ross C. |

    And DateOfBirth query params are used with following values

      | 1934-06-01 |
      | 1956-05-01 |
      | 1966-04-01 |
      | 2000-03-01 |

    And Address query params are used with following values

      | CA           |
      | MD           |
      | CA State     |
      | Valley State |



    When I send GET request TCThree
    Then status code should be 200 TCThree
    And response content-type should be "application/json" TCThree
   # And payload must display patient data equal to expected data


