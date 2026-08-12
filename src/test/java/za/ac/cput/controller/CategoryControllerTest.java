package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

/*
 CategoryControllerTest.java
 Category Controller Test
 Author: Sinoxolo Kobeni (230801846)
 Date: 19/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryControllerTest {

    private static final CategoryController controller = new CategoryController();

    private static final Category category = new Category.Builder()
            .setCategoryId("C001")
            .setName("Electronics")
            .setParentId("P000")
            .build();

    @Test
    @Order(1)
    void create() {
        Category created = controller.create(category);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Category read = controller.read(category.getCategoryId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Category updated = new Category.Builder()
                .copy(category)
                .setName("Home Electronics")
                .build();

        assertEquals("Home Electronics",
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
        assertTrue(controller.delete(category.getCategoryId()));
    }
}