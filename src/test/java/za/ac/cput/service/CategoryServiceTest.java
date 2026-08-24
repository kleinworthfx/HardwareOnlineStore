package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Category;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

/* CategoryServiceTest.java
   Category Service Test
   Author: Sinoxolo Kobeni (230801846)
   Date: 12/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryServiceTest {

    private static final CategoryService service = CategoryService.getService();

    private static final Category category =
            CategoryFactory.createCategory(
                    "C001",
                    "Tools",
                    null
            );

    @Test
    @Order(1)
    void create() {

        Category created = service.create(category);

        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {

        Category read = service.read(category.getCategoryId());

        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Category updated = new Category.Builder()
                .copy(category)
                .setName("Power Tools")
                .build();

        Category result = service.update(updated);

        assertEquals("Power Tools", result.getName());
    }

    @Test
    @Order(4)
    void getAll() {

        assertFalse(service.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {

        assertTrue(service.delete(category.getCategoryId()));
    }
}