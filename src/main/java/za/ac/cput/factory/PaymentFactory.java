package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;
import java.math.BigDecimal;
import java.util.Date;

/* Payment.java
   Payment Factory Entity using Builder Pattern
   Author: [Khonzinkosi] ([230231802])
   Date: 21 June 2026 */

public class PaymentFactory {

    public static Payment createPayment(String paymentId, String orderId, String paymentMethod,
                                        String transactionId, Date paymentDate, BigDecimal amount,
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
