package za.ac.cput.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

import java.util.Objects;

/* Customer.java
   Customer Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

@Entity
@Table(name = "customer")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_id", nullable=false, length=255, unique=true)
    private String customerId;
    @Column(nullable=false, length=255)
    private String name;
    @Column(nullable=false, length=255, unique=true)
    private String email;
    @Column(name="password_hash", nullable=false, length=255)
    private String passwordHash;
    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipping_address_id", nullable = false)
    private Address shippingAddress;

    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "billing_address_id", nullable = false)
    private Address billingAddress;

    protected Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.shippingAddress = builder.shippingAddress;
        this.billingAddress = builder.billingAddress;
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
    }

    public Long getId() { return id; }
    public Address getShippingAddress() { return shippingAddress; }
    public Address getBillingAddress() { return billingAddress; }
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }

    public static Builder builder() { return new Builder(); }

    public static Builder copy(Customer entity) {
        return new Builder()
                .id(entity.id)
                .shippingAddress(entity.getShippingAddress())
                .billingAddress(entity.getBillingAddress())
                .customerId(entity.getCustomerId())
                .name(entity.getName())
                .email(entity.getEmail())
                .passwordHash(entity.getPasswordHash());
    }

    public static final class Builder {
        private Long id;
        private Address shippingAddress;
        private Address billingAddress;
        private String customerId;
        private String name;
        private String email;
        private String passwordHash;
        public Builder id(Long id) { this.id = id; return this; }
        public Builder shippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; return this; }
        public Builder billingAddress(Address billingAddress) { this.billingAddress = billingAddress; return this; }
        public Builder customerId(String customerId) { this.customerId = customerId; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder passwordHash(String passwordHash) { this.passwordHash = passwordHash; return this; }
        public Customer build() {
            if (shippingAddress == null || billingAddress == null) throw new IllegalArgumentException("Addresses are required");
            if (customerId == null) throw new IllegalArgumentException("customerId is required");
            if (name == null) throw new IllegalArgumentException("name is required");
            if (email == null) throw new IllegalArgumentException("email is required");
            if (passwordHash == null) throw new IllegalArgumentException("passwordHash is required");

            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer other)) return false;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }

    @Override
    public String toString() { return "Customer" + "{id=" + id + "}"; }
}
