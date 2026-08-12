package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/*
 ProductControllerTest.java
 Product Controller Test
 Author: Sinoxolo Kobeni (230801846)
 Date: 19/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    private static final ProductController controller = new ProductController();

    private static final Product product = new Product.Builder()
            .setProductId("P001")
            .setCategoryId("C001")
            .setName("Laptop")
            .setSku("LAP001")
            .setDescription("Dell Laptop")
            .setPrice(new BigDecimal("15000.00"))
            .setWeight(2.5)
            .setDimensions("35x25x2 cm")
            .setImageUrl("laptop.jpg")
            .build();

    @Test
    @Order(1)
    void create() {
        Product created = controller.create(product);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Product read = controller.read(product.getProductId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Product updated = new Product.Builder()
                .copy(product)
                .setName("Gaming Laptop")
                .build();

        assertEquals("Gaming Laptop",
                controller.update(updated).getName());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(controller.delete(product.getProductId()));
    }
}