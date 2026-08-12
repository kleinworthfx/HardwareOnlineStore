package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

/* CategoryFactoryTest.java
   TDD Unit Tests for Category Factory
   Author: Sinoxolo Kobeni (230801846)
   Date: 28 June 2026 */

class CategoryFactoryTest {

    @Test
    void createCategory() {

        Category category = CategoryFactory.createCategory(
                "C001",
                "Tools",

                null
        );

        assertNotNull(category);
        assertEquals("Tools", category.getName());
    }

    @Test
    void createCategoryWithInvalidData() {

        Category category = CategoryFactory.createCategory(
                "",
                "",
                ""
        );

        assertNull(category);
    }
}