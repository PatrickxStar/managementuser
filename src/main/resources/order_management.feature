Feature: Order Management

  Scenario: Create a new order
    Given a customer named "John Doe"
    When I create a new order with status "PENDING"
    Then the order should be created successfully
