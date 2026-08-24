package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.*;

/* InventoryControllerTest.java
   Controller Integration Tests for Inventory Endpoints
   Author: Khonzinkosi Khumalo (230231802)
   Date: 19 July 2026 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/inventory";
    private static final Inventory inventory = InventoryFactory.createInventory(
            "INV-881", "PROD-202", 120, 10, "Warehouse Row B"
    );

    @Test
    @Order(1)
    void testCreate() {
        String url = baseUrl + "/create";
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, inventory, Inventory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(inventory.getInventoryId(), postResponse.getBody().getInventoryId());
    }

    @Test
    @Order(2)
    void testRead() {
        String url = baseUrl + "/read/" + inventory.getInventoryId();
        ResponseEntity<Inventory> response = restTemplate.getForEntity(url, Inventory.class);
        assertNotNull(response.getBody());
        assertEquals(inventory.getInventoryId(), response.getBody().getInventoryId());
    }

    @Test
    @Order(3)
    void testUpdate() {
        String url = baseUrl + "/update";
        Inventory updated = new Inventory.Builder().copy(inventory).setQuantityInStock(115).build();
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, updated, Inventory.class);
        assertNotNull(postResponse.getBody());
        assertEquals(115, postResponse.getBody().getQuantityInStock());
    }

    @Test
    @Order(4)
    void testGetAll() {
        String url = baseUrl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}