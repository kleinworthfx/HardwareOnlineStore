package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/* Payment.java
   Payment Domain Entity using Builder Pattern
   Author: Khonzinkosi Khumalo (230231802)
   Date: 21 June 2026 */

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private String paymentId;
    private String orderId;
    private String paymentMethod;
    private String transactionId;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private String paymentStatus;

    // Default constructor required by JPA
    protected Payment() {
    }

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
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public BigDecimal getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentId;
        private String orderId;
        private String paymentMethod;
        private String transactionId;
        private LocalDateTime paymentDate;
        private BigDecimal amount;
        private String paymentStatus;

        public Builder setPaymentId(String paymentId) { this.paymentId = paymentId; return this; }
        public Builder setOrderId(String orderId) { this.orderId = orderId; return this; }
        public Builder setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; return this; }
        public Builder setTransactionId(String transactionId) { this.transactionId = transactionId; return this; }
        public Builder setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; return this; }
        public Builder setAmount(BigDecimal amount) { this.amount = amount; return this; }
        public Builder setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; return this; }

        public Builder copy(Payment payment) {
            if (payment != null) {
                this.paymentId = payment.paymentId;
                this.orderId = payment.orderId;
                this.paymentMethod = payment.paymentMethod;
                this.transactionId = payment.transactionId;
                this.paymentDate = payment.paymentDate;
                this.amount = payment.amount;
                this.paymentStatus = payment.paymentStatus;
            }
            return this;
        }

        public Payment build() {
            Objects.requireNonNull(paymentId, "Financial transaction gateway reconciliation key required");
            return new Payment(this);
        }
    }
}