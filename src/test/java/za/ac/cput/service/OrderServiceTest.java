package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/* OrderServiceTest.java
   Unit Tests for OrderService utilizing Mockito
   Author: Francine Mulangu Kasongo (230978649)
   Date: 12 July 2026 */
class OrderServiceTest {

    @Mock
    private IOrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void testCreateOrder() {
        Order mockOrder = new Order.Builder()
                .setOrderId("ORD-001")
                .setOrderDate(LocalDate.now())
                .setStatus("Pending")
                .build();

        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);

        Order createdOrder = orderService.createOrder("ORD-001", "Pending");

        assertNotNull(createdOrder);
        assertEquals("ORD-001", createdOrder.getOrderId());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testGetOrderById() {
        Order mockOrder = new Order.Builder()
                .setOrderId("ORD-001")
                .setOrderDate(LocalDate.now())
                .setStatus("Pending")
                .build();

        when(orderRepository.findById("ORD-001")).thenReturn(Optional.of(mockOrder));

        Optional<Order> result = orderService.getOrderById("ORD-001");

        assertTrue(result.isPresent());
        assertEquals("ORD-001", result.get().getOrderId());
    }

    @Test
    void testAddItemToOrder() {
        Order existingOrder = new Order.Builder()
                .setOrderId("ORD-001")
                .setOrderDate(LocalDate.now())
                .setStatus("Pending")
                .build();

        when(orderRepository.findById("ORD-001")).thenReturn(Optional.of(existingOrder));
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order updatedOrder = orderService.addItemToOrder("ORD-001", "ITEM-001", 2, 50.0);

        assertNotNull(updatedOrder);
        assertEquals(1, updatedOrder.getItems().size());
        assertEquals(100.0, updatedOrder.getTotalAmount()); // 2 * 50.0
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testDeleteOrder() {
        orderService.deleteOrder("ORD-001");
        verify(orderRepository, times(1)).deleteById("ORD-001");
    }
}