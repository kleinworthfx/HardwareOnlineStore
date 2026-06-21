package za.ac.cput.domain;

import java.util.Objects;

/* Inventory.java
   Inventory Domain Entity using Builder Pattern
   Author: [Khonzinkosi] ([230231802])
   Date: 21 June 2026 */

public class Inventory {
    private final String inventoryId;
    private final String productId;
    private final int quantityInStock;
    private final int reorderLevel;
    private final String locationWarehouse;

    private Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.productId = builder.productId;
        this.quantityInStock = builder.quantityInStock;
        this.reorderLevel = builder.reorderLevel;
        this.locationWarehouse = builder.locationWarehouse;
    }

    public String getInventoryId() { return inventoryId; }
    public String getProductId() { return productId; }
    public int getQuantityInStock() { return quantityInStock; }
    public int getReorderLevel() { return reorderLevel; }
    public String getLocationWarehouse() { return locationWarehouse; }

    @Override
    public String toString() {
        return "Inventory{" + "id='" + inventoryId + '\'' + ", inStock=" + quantityInStock + ", reorderAt=" + reorderLevel + '}';
    }

    public static class Builder {
        private String inventoryId;
        private String productId;
        private int quantityInStock;
        private int reorderLevel;
        private String locationWarehouse;

        public Builder setInventoryId(String inventoryId) { this.inventoryId = inventoryId; return this; }
        public Builder setProductId(String productId) { this.productId = productId; return this; }
        public Builder setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; return this; }
        public Builder setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; return this; }
        public Builder setLocationWarehouse(String locationWarehouse) { this.locationWarehouse = locationWarehouse; return this; }

        public Builder copy(Inventory inventory) {
            this.inventoryId = inventory.inventoryId;
            this.productId = inventory.productId;
            this.quantityInStock = inventory.quantityInStock;
            this.reorderLevel = inventory.reorderLevel;
            this.locationWarehouse = inventory.locationWarehouse;
            return this;
        }

        public Inventory build() {
            Objects.requireNonNull(inventoryId, "Inventory ledger configuration tracking key identity required");
            return new Inventory(this);
        }
    }
}
