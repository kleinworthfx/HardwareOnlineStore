package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Inventory;

/* Payment.java
   Payment Factory Entity using Builder Pattern
   Author: [Khonzinkosi] ([230231802])
   Date: 21 June 2026 */

public class InventoryFactory {

    public static Inventory createInventory(String inventoryId, String productId, int quantityInStock,
                                            int reorderLevel, String locationWarehouse) {
        if (Helper.isNullOrEmpty(inventoryId) || Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(locationWarehouse)) {
            return null;
        }
        if (quantityInStock < 0 || reorderLevel < 0) {
            return null;
        }

        return new Inventory.Builder()
                .setInventoryId(inventoryId)
                .setProductId(productId)
                .setQuantityInStock(quantityInStock)
                .setReorderLevel(reorderLevel)
                .setLocationWarehouse(locationWarehouse)
                .build();
    }
}
