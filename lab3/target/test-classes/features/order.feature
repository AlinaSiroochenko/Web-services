Feature: Customer Order Management

  Scenario: Create a new order
    Given the order database is initialized
    When I send a POST request to "/orders" with body for order
      """
      {
        "date": "2024-06-12",
        "status": "Pending"
      }
      """
    Then the response status should be 201 for order
    And the response should contain the order details

  Scenario: Get an order by ID
    Given the order database is initialized
    When I send a GET request to "/orders/1" for order
    Then the response status should be 200 for order
    And the response should contain the order details

  Scenario: Update an existing order
    Given the order database is initialized
    When I send a PUT request to "/orders/1" with body for order
      """
      {
        "date": "2024-06-13",
        "status": "Completed"
      }
      """
    Then the response status should be 200 for order
    And the response should contain the updated order details

  Scenario: Delete an order
    Given the order database is initialized
    When I send a DELETE request to "/orders/1" for order
    Then the response status should be 204 for order
