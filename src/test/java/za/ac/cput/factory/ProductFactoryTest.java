package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
/* ProductFactoryTest.java
   TDD Unit Tests for Product Factory
   Author: Sinoxolo Kobeni (230801846)
   Date: 28 June 2026 */

class ProductFactoryTest {

    @Test
    void createProduct() {

        Product product = ProductFactory.createProduct(
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

        assertNotNull(product);
        assertEquals("Hammer", product.getName());
    }

    @Test
    void createProductWithInvalidData() {

        Product product = ProductFactory.createProduct(
                "",
                "",
                "",
                "",
                "",
                null,
                0,
                "",
                ""
        );

        assertNull(product);
    }
}