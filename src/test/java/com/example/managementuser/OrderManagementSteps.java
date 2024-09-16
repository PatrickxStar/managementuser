package com.example.managementuser;

import com.example.managementuser.Entities.Order;
import com.example.managementuser.services.OrderService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderManagementSteps {

    private Order order;

    @Given("a customer named {string}")
    public void aCustomerNamed(String customerName) {
        order = new Order();
        order.setCustomerName(customerName);
    }

    @When("I create a new order with status {string}")
    public void iCreateANewOrderWithStatus(String status) {
        order.setStatus(status);
        order = new OrderService().createOrder(order);
    }

    @Then("the order should be created successfully")
    public void theOrderShouldBeCreatedSuccessfully() {
        assertNotNull(order);
    }
}
