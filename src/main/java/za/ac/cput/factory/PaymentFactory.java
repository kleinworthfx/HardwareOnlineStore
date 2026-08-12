package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* PaymentFactory.java
   Payment Factory implementation
   Author: Khonzinkosi Khumalo (230231802)
   Date: 21 June 2026 */

public class PaymentFactory {

    public static Payment createPayment(String paymentId, String orderId, String paymentMethod,
                                        String transactionId, LocalDateTime paymentDate, BigDecimal amount,
                                        String paymentStatus) {
        if (Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(orderId) ||
                Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(paymentStatus)) {
            return null;
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 || paymentDate == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setOrderId(orderId)
                .setPaymentMethod(paymentMethod)
                .setTransactionId(transactionId)
                .setPaymentDate(paymentDate)
                .setAmount(amount)
                .setPaymentStatus(paymentStatus)
                .build();
    }
}