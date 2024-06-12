Feature: Table Management

  Scenario: Create a new table
    Given the table database is initialized
    When I send a POST request to "/tables" with body for table
      """
      {
        "number": 1,
        "seats": 4
      }
      """
    Then the response status should be 201 for table
    And the response should contain the table details

  Scenario: Get a table by ID
    Given the table database is initialized
    When I send a GET request to "/tables/1" for table
    Then the response status should be 200 for table
    And the response should contain the table details

  Scenario: Update an existing table
    Given the table database is initialized
    When I send a PUT request to "/tables/1" with body for table
      """
      {
        "number": 2,
        "seats": 6
      }
      """
    Then the response status should be 200 for table
    And the response should contain the updated table details

  Scenario: Delete a table
    Given the table database is initialized
    When I send a DELETE request to "/tables/1" for table
    Then the response status should be 204 for table
