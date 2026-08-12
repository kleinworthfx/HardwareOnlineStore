package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/* OrderFactoryTest.java
   Unit Test for OrderFactory
   Author: Francine Mulangu Kasongo (230978649)
   Date: 28 June 2026 */
public class OrderFactoryTest {

    @Test
    void testCreateValidOrder() {
        // Updated to pass valid orderId, orderDate, and status required by Order.Builder validation
        Order order = OrderFactory.createOrder("ORD-999", "Pending");

        assertNotNull(order);
        assertEquals("ORD-999", order.getOrderId());
        assertEquals("Pending", order.getStatus());
        assertEquals(0.0, order.getTotalAmount());
    }

    @Test
    void testCreateOrderWithNullValues() {
        // Tests the validation logic in OrderFactory/Order.Builder
        Order order = OrderFactory.createOrder("", "Pending");
        assertNull(order);
    }
}