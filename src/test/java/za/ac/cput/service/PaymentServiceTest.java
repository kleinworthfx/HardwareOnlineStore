package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/* PaymentServiceTest.java
   Service Integration Tests for Payment Service
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    private static final Payment payment = PaymentFactory.createPayment(
            "PAY-992", "ORD-881", "EFT", "TXN-0012", LocalDateTime.now(), new BigDecimal("1200.00"), "PENDING"
    );

    @Test
    @Order(1)
    void testCreate() {
        Payment created = service.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentId(), created.getPaymentId());
    }

    @Test
    @Order(2)
    void testRead() {
        Payment read = service.read(payment.getPaymentId());
        assertNotNull(read);
        assertEquals("EFT", read.getPaymentMethod());
    }

    @Test
    @Order(3)
    void testUpdate() {
        Payment updated = new Payment.Builder().copy(payment)
                .setPaymentStatus("COMPLETED")
                .build();
        Payment result = service.update(updated);
        assertNotNull(result);
        assertEquals("COMPLETED", result.getPaymentStatus());
    }

    @Test
    @Order(4)
    void testGetAll() {
        List<Payment> payments = service.getAll();
        assertFalse(payments.isEmpty());
    }
}