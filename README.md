# Order Management System

This project is an Order Management System that demonstrates CRUD operations for managing orders and products using Spring Boot. The project follows the Test-Driven Development (TDD) methodology using JUnit for testing.

## Project Overview

- **Technologies Used**: Spring Boot, Spring Data JPA, Lombok, H2 Database, JUnit (for TDD), Cucumber (optional for BDD)
- **Purpose**: Implement CRUD operations for orders and products and test the application using JUnit (or Cucumber).

## Methodology

### Chosen Methodology: Test-Driven Development (TDD)

The project follows the TDD approach using JUnit for testing. In TDD, test cases are written before the actual implementation code. The primary goal is to ensure that the application meets its functional requirements while maintaining high code quality.

- **Tools Used**:
   - **JUnit**: For writing and running unit tests.
   - **Mockito**: For mocking dependencies in service layer tests.

- **Tools Used**:
   - **JUnit**: For executing BDD scenarios.

## Test Cases

### JUnit Test Cases (TDD)

The following test cases were written to validate the functionalities of the `OrderService` and `ProductService`:

#### `OrderServiceTest`

- **testCreateOrder()**: Validates the creation of a new order.
- **testUpdateOrder()**: Verifies that an existing order can be updated correctly.
- **testDeleteOrder()**: Ensures that an order can be deleted by its ID.
- **testGetAllOrders()**: Checks that all orders can be retrieved from the database.
- **testGetOrderById()**: Verifies that an order can be retrieved by its ID.

#### `ProductServiceTest`

- **testCreateProduct()**: Validates the creation of a new product.
- **testUpdateProduct()**: Verifies that an existing product can be updated correctly.
- **testDeleteProduct()**: Ensures that a product can be deleted by its ID.
- **testGetAllProducts()**: Checks that all products can be retrieved from the database.
- **testGetProductById()**: Verifies that a product can be retrieved by its ID.

### Test Results

#### JUnit Test Results

All JUnit test cases were executed successfully, with the following results:

- **Total Tests Run**: 10
- **Tests Passed**: 10
- **Tests Failed**: 0

## Running the Tests

### Running JUnit Tests

To run the JUnit tests, use the following commands:

- **Using IntelliJ IDEA**:
   - Right-click on the test class (`OrderServiceTest` or `ProductServiceTest`) and select **Run 'OrderServiceTest'** or **Run 'ProductServiceTest'**.

- **Using Command Line**:
   - For **Maven**:
     ```bash
     mvn test

- **Using IntelliJ IDEA**:
   - Right-click on the feature file (`order_management.feature`) and select **Run 'order_management.feature'**.

- **Using Command Line**:
   - For **Maven**:
     ```bash
     mvn test

## Additional Information

- **H2 Database Configuration:**
   - The application uses an in-memory H2 database for simplicity.
   - You can access the H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
