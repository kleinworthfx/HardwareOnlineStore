package za.ac.cput.entity;

import java.util.Objects;

/* CartItem.java
   CartItem Domain Entity using Builder Pattern
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
public class CartItem {
    private final String cartItemId;
    private final String cartId;
    private final String productId;
    private final int quantity;

    private CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.cartId = builder.cartId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }

    public String getCartItemId() { return cartItemId; }
    public String getCartId() { return cartId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "CartItem{" + "cartItemId='" + cartItemId + '\'' + ", productId='" + productId + '\'' + ", quantity=" + quantity + '}';
    }

    public static class Builder {
        private String cartItemId;
        private String cartId;
        private String productId;
        private int quantity;

        public Builder setCartItemId(String cartItemId) { this.cartItemId = cartItemId; return this; }
        public Builder setCartId(String cartId) { this.cartId = cartId; return this; }
        public Builder setProductId(String productId) { this.productId = productId; return this; }
        public Builder setQuantity(int quantity) { this.quantity = quantity; return this; }

        public Builder copy(CartItem item) {
            this.cartItemId = item.cartItemId;
            this.cartId = item.cartId;
            this.productId = item.productId;
            this.quantity = item.quantity;
            return this;
        }

        public CartItem build() {
            Objects.requireNonNull(cartItemId, "Cart Item ID cannot be null");
            Objects.requireNonNull(cartId, "Cart ID reference required");
            Objects.requireNonNull(productId, "Product ID reference required");
            if (quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero");
            return new CartItem(this);
        }
    }
}

