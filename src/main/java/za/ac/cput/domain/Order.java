package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* Order.java
   Order Domain Entity using Builder Pattern & JPA Annotations
   Author: Francine Mulangu Kasongo (230978649)
   Date: 21 June 2026 */


public class Order {


    private String orderId;
    private LocalDate orderDate;
    private String status;
    private double totalAmount;
    private List<OrderItem> items = new ArrayList<>();

    // Required default constructor for JPA reflection engine
    protected Order() {
    }

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.items = builder.items != null ? builder.items : new ArrayList<>();
        this.totalAmount = calculateTotal();
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getItems() {
        return items != null ? Collections.unmodifiableList(items) : Collections.emptyList();
    }

    private double calculateTotal() {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (OrderItem item : items) {
            // Assuming OrderItem provides getQuantity() and getUnitPrice()
            sum += item.getQuantity() * item.getUnitPrice();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", itemsCount=" + (items != null ? items.size() : 0) +
                '}';
    }

    public static class Builder {
        private String orderId;
        private LocalDate orderDate;
        private String status;
        private List<OrderItem> items = new ArrayList<>();

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setItems(List<OrderItem> items) {
            this.items = items != null ? new ArrayList<>(items) : new ArrayList<>();
            return this;
        }

        public Builder addItem(OrderItem item) {
            if (item != null) {
                this.items.add(item);
            }
            return this;
        }

        public Builder addItems(List<OrderItem> items) {
            if (items != null) {
                this.items.addAll(items);
            }
            return this;
        }

        public Builder copy(Order order) {
            if (order != null) {
                this.orderId = order.orderId;
                this.orderDate = order.orderDate;
                this.status = order.status;
                this.items = order.items != null ? new ArrayList<>(order.items) : new ArrayList<>();
            }
            return this;
        }

        public Order build() {
            if (Helper.isNullOrEmpty(orderId)) {
                throw new IllegalArgumentException("orderId is required");
            }
            if (orderDate == null) {
                throw new IllegalArgumentException("Date is required");
            }
            if (Helper.isNullOrEmpty(status)) {
                throw new IllegalArgumentException("Status is required");
            }
            return new Order(this);
        }
    }
}