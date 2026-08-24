package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Product;
import za.ac.cput.factory.ProductFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/* ProductServiceTest.java
   Product Service Test
   Author: Sinoxolo Kobeni (230801846)
   Date: 12/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

    private static final ProductService service = ProductService.getService();

    private static final Product product =
            ProductFactory.createProduct(
                    "P001",
                    "C001",
                    "Hammer",
                    "HAM001",
                    "Steel Hammer",
                    new BigDecimal("199.99"),
                    1.5,
                    "25x10x5",
                    "hammer.jpg"
            );

    @Test
    @Order(1)
    void create() {

        Product created = service.create(product);

        assertNotNull(created);
        assertEquals(product.getProductId(), created.getProductId());
    }

    @Test
    @Order(2)
    void read() {

        Product read = service.read(product.getProductId());

        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Product updated = new Product.Builder()
                .copy(product)
                .setName("Cordless Drill")
                .build();

        Product result = service.update(updated);

        assertEquals("Cordless Drill", result.getName());
    }

    @Test
    @Order(4)
    void getAll() {

        assertFalse(service.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {

        assertTrue(service.delete(product.getProductId()));
    }
}