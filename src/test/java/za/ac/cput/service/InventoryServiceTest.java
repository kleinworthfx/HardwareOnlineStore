package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/* InventoryServiceTest.java
   Service Integration Tests for Inventory Service
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceTest {

    @Autowired
    private IInventoryService service;

    private static final Inventory inventory = InventoryFactory.createInventory(
            "INV-332", "PROD-102", 50, 5, "Bay C"
    );

    @Test
    @Order(1)
    void testCreate() {
        Inventory created = service.create(inventory);
        assertNotNull(created);
        assertNotNull(inventory);
        assertEquals(inventory.getInventoryId(), created.getInventoryId());
    }

    @Test
    @Order(2)
    void testRead() {
        assertNotNull(inventory);
        Inventory read = service.read(inventory.getInventoryId());
        assertNotNull(read);
        assertEquals(50, read.getQuantityInStock());
    }

    @Test
    @Order(3)
    void testUpdate() {
        assertNotNull(inventory);
        Inventory updated = new Inventory.Builder().copy(inventory)
                .setQuantityInStock(45)
                .build();
        Inventory result = service.update(updated);
        assertNotNull(result);
        assertEquals(45, result.getQuantityInStock());
    }

    @Test
    @Order(4)
    void testGetAll() {
        List<Inventory> inventoryList = service.getAll();
        assertFalse(inventoryList.isEmpty());
    }
}