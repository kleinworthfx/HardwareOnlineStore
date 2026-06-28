
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;

import static org.junit.jupiter.api.Assertions.*;

/* InventoryFactoryTest.java
   TDD Unit Tests for Inventory Factory
   Author: [Khonzinkosi] (230231802)
   Date: 28 June 2026 */
class InventoryFactoryTest {

    @Test
    void testCreateInventorySuccess() {
        Inventory inventory = InventoryFactory.createInventory(
                "INV-001",
                "PROD-8899",
                150,
                20,
                "Aisle 4B"
        );
        assertNotNull(inventory);
        assertEquals("INV-001", inventory.getInventoryId());
        assertEquals("PROD-8899", inventory.getProductId());
        assertEquals(150, inventory.getQuantityInStock());
        assertEquals(20, inventory.getReorderLevel());
        assertEquals("Aisle 4B", inventory.getLocationWarehouse());
    }

    @Test
    void testCreateInventoryWithNegativeStockReturnsNull() {
        Inventory inventory = InventoryFactory.createInventory(
                "INV-001",
                "PROD-8899",
                -5,
                20,
                "Aisle 4B"
        );
        assertNull(inventory);
    }

    @Test
    void testCreateInventoryWithMissingWarehouseLocationReturnsNull() {
        Inventory inventory = InventoryFactory.createInventory(
                "INV-001",
                "PROD-8899",
                150,
                20,
                ""
        );
        assertNull(inventory);
    }
}