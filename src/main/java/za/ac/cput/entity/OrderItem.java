package za.ac.cput.entity;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 21 June 2026
 */

public class OrderItem {
    private final String itemId;
    private final double unitPrice;
    private final int quantity;
    private final double subtotal;


    private OrderItem(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.subtotal = builder.build().subtotal;

    }

    public String getItemId() {
        return itemId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }


    @Override
    public String toString() {
        return "OrderItem{" + " itemId =" + itemId + "\" " + ", quantity" + quantity + " , unitPrice =" + unitPrice + ", subtotal = " + subtotal + "}";
    }


    public static class Builder {
        private String itemId;
        private int quantity;
        private double unitPrice;

        public Builder setItemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public OrderItem build() {

            if (Helper.isNullOrEmpty(itemId))
                throw new IllegalArgumentException("Item ID is required");
            if (Helper.isNullOrEmpty(quantity))
                throw new IllegalArgumentException("Excedded !!");
            if (Helper.isNullOrEmpty(unitPrice))
                throw new IllegalArgumentException("Invalid price!!!");

            return new OrderItem(this);
        }

    }
}
