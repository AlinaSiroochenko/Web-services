Feature: Dish management

  Scenario: Create a new dish
    Given the dish database is initialized
    When I send a POST request to "/dishes" with body for dish
      """
      {
        "name": "Pizza",
        "price": 12.99
      }
      """
    Then the response status should be 201 for dish
    And the response should contain the dish details

  Scenario: Update an existing dish
    Given the dish database is initialized
    When I send a PUT request to "/dishes/1" with body for dish
      """
      {
        "name": "Spaghetti",
        "price": 9.99
      }
      """
    Then the response status should be 200 for dish
    And the response should contain the updated dish details

  Scenario: Delete a dish
    Given the dish database is initialized
    When I send a DELETE request to "/dishes/1" for dish
    Then the response status should be 204 for dish
