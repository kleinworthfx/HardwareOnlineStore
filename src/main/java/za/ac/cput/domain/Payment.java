package za.ac.cput.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/* Payment.java
   Payment Domain Entity using Builder Pattern
   Author: [Khonzinkosi] ([230231802])
   Date: 21 June 2026 */

public class Payment {
    private final String paymentId;
    private final String orderId;
    private final String paymentMethod;
    private final String transactionId;
    private final Date paymentDate;
    private final BigDecimal amount;
    private final String paymentStatus;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.orderId = builder.orderId;
        this.paymentMethod = builder.paymentMethod;
        this.transactionId = builder.transactionId;
        this.paymentDate = builder.paymentDate;
        this.amount = builder.amount;
        this.paymentStatus = builder.paymentStatus;
    }

    public String getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public Date getPaymentDate() { return paymentDate; }
    public BigDecimal getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }

    @Override
    public String toString() {
        return "Payment{" + "paymentId='" + paymentId + '\'' + ", status='" + paymentStatus + '\'' + ", amount=" + amount + '}';
    }

    public static class Builder {
        private String paymentId;
        private String orderId;
        private String paymentMethod;
        private String transactionId;
        private Date paymentDate;
        private BigDecimal amount;
        private String paymentStatus;

        public Builder setPaymentId(String paymentId) { this.paymentId = paymentId; return this; }
        public Builder setOrderId(String orderId) { this.orderId = orderId; return this; }
        public Builder setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; return this; }
        public Builder setTransactionId(String transactionId) { this.transactionId = transactionId; return this; }
        public Builder setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; return this; }
        public Builder setAmount(BigDecimal amount) { this.amount = amount; return this; }
        public Builder setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; return this; }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.orderId = payment.orderId;
            this.paymentMethod = payment.paymentMethod;
            this.transactionId = payment.transactionId;
            this.paymentDate = payment.paymentDate;
            this.amount = payment.amount;
            this.paymentStatus = payment.paymentStatus;
            return this;
        }

        public Payment build() {
            Objects.requireNonNull(paymentId, "Financial transaction gateway reconciliation key required");
            return new Payment(this);
        }
    }
}
