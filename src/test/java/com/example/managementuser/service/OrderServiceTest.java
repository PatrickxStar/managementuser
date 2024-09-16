package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        order.setCustomerName("John Doe");
        order.setStatus("PENDING");

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);
        assertNotNull(createdOrder);
        assertEquals("John Doe", createdOrder.getCustomerName());
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.setCustomerName("John Doe");
        orders.add(order1);

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> allOrders = orderService.getAllOrders();
        assertEquals(1, allOrders.size());
        assertEquals("John Doe", allOrders.get(0).getCustomerName());
    }
}
