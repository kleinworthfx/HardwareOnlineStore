package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/* PaymentFactoryTest.java
   TDD Unit Tests for Payment Factory
   Author: [Khonzinkosi] (230231802)
   Date: 28 June 2026 */

class PaymentFactoryTest {

    @Test
    void testCreatePaymentSuccess() {
        Payment payment = PaymentFactory.createPayment(
                "PAY-1001",
                "ORD-5542",
                "EFT",
                "TXN-998877",
                new Date(),
                new BigDecimal("1450.50"),
                "COMPLETED"
        );
        assertNotNull(payment);
        assertEquals("PAY-1001", payment.getPaymentId());
        assertEquals("ORD-5542", payment.getOrderId());
        assertEquals("EFT", payment.getPaymentMethod());
        assertEquals("COMPLETED", payment.getPaymentStatus());
    }

    @Test
    void testCreatePaymentWithMissingOrderIdReturnsNull() {
        Payment payment = PaymentFactory.createPayment(
                "PAY-1001",
                "", // Invalid Empty Order ID string
                "Credit Card",
                "TXN-112233",
                new Date(),
                new BigDecimal("500.00"),
                "PENDING"
        );
        assertNull(payment);
    }

    @Test
    void testCreatePaymentWithNegativeAmountReturnsNull() {
        Payment payment = PaymentFactory.createPayment(
                "PAY-1001",
                "ORD-5542",
                "EFT",
                "TXN-998877",
                new Date(),
                new BigDecimal("-50.00"), // Invalid Negative Amount
                "COMPLETED"
        );
        assertNull(payment);
    }
}