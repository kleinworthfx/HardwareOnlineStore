package za.ac.cput.entity;

import java.util.Date;
import java.util.Objects;

/* Cart.java
   Cart Domain Entity using Builder Pattern
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
public class Cart {
    private final String cartId;
    private final String customerId;
    private final Date lastUpdated;

    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customerId = builder.customerId;
        this.lastUpdated = builder.lastUpdated;
    }

    public String getCartId() { return cartId; }
    public String getCustomerId() { return customerId; }
    public Date getLastUpdated() { return lastUpdated; }

    @Override
    public String toString() {
        return "Cart{" + "cartId='" + cartId + '\'' + ", customerId='" + customerId + '\'' + '}';
    }

    public static class Builder {
        private String cartId;
        private String customerId;
        private Date lastUpdated;

        public Builder setCartId(String cartId) { this.cartId = cartId; return this; }
        public Builder setCustomerId(String customerId) { this.customerId = customerId; return this; }
        public Builder setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; return this; }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.customerId = cart.customerId;
            this.lastUpdated = cart.lastUpdated;
            return this;
        }

        public Cart build() {
            Objects.requireNonNull(cartId, "Cart ID cannot be null");
            Objects.requireNonNull(customerId, "Customer ID cannot be null");
            return new Cart(this);
        }
    }
}

