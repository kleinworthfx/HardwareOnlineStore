package za.ac.cput.domain;

import za.ac.cput.util.Helper;

/* Customer.java
   Customer Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

public class Customer {
    private final String customerId;
    private final String name;
    private final String email;
    private final String passwordHash;
    private final Address shippingAddress;
    private final Address billingAddress;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.shippingAddress = builder.shippingAddress;
        this.billingAddress = builder.billingAddress;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Address getShippingAddress() { return shippingAddress; }
    public Address getBillingAddress() { return billingAddress; }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String name;
        private String email;
        private String passwordHash;
        private Address shippingAddress;
        private Address billingAddress;

        public Builder setCustomerId(String customerId) { this.customerId = customerId; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; return this; }
        public Builder setShippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; return this; }
        public Builder setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; return this; }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.name = customer.name;
            this.email = customer.email;
            this.passwordHash = customer.passwordHash;
            this.shippingAddress = customer.shippingAddress;
            this.billingAddress = customer.billingAddress;
            return this;
        }

        public Customer build() {
            if (Helper.isNullOrEmpty(customerId))
                throw new IllegalArgumentException("Customer ID is required");
            if (Helper.isNullOrEmpty(name))
                throw new IllegalArgumentException("Customer name is required");
            if (!Helper.isValidEmail(email))
                throw new IllegalArgumentException("A valid email address is required");
            if (Helper.isNullOrEmpty(passwordHash))
                throw new IllegalArgumentException("Password hash is required");
            if (Helper.isNullOrEmpty(shippingAddress))
                throw new IllegalArgumentException("Shipping address is required");
            if (Helper.isNullOrEmpty(billingAddress))
                throw new IllegalArgumentException("Billing address is required");
            return new Customer(this);
        }
    }
}