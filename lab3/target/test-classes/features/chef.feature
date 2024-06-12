Feature: Chef Management

  Scenario: Create a new chef
    Given the chef database is initialized
    When I send a POST request to "/chefs" with body for chef
      """
      {
        "name": "Gordon Ramsay",
        "experience": 30
      }
      """
    Then the response status should be 201 for chef
    And the response should contain the chef details

  Scenario: Get a chef by ID
    Given the chef database is initialized
    When I send a GET request to "/chefs/1" for chef
    Then the response status should be 200 for chef
    And the response should contain the chef details

  Scenario: Update an existing chef
    Given the chef database is initialized
    When I send a PUT request to "/chefs/1" with body for chef
      """
      {
        "name": "Jamie Oliver",
        "experience": 25
      }
      """
    Then the response status should be 200 for chef
    And the response should contain the updated chef details

  Scenario: Delete a chef
    Given the chef database is initialized
    When I send a DELETE request to "/chefs/1" for chef
    Then the response status should be 204 for chef
