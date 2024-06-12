Feature: Customer management

  Scenario: Create a new customer
    Given the database is initialized
    When I send a POST request to "/customers" with body
      """
      {
        "name": "Jane Doe",
        "email": "jane.doe@example.com"
      }
      """
    Then the response status should be 201
    And the response should contain the customer details

  Scenario: Update an existing customer
    Given the database is initialized
    When I send a PUT request to "/customers/1" with body
      """
      {
        "name": "Jane Doe",
        "email": "jane.doe@example.com"
      }
      """
    Then the response status should be 200
    And the response should contain the updated customer details

  Scenario: Delete a customer
    Given the database is initialized
    When I send a DELETE request to "/customers/1"
    Then the response status should be 204
