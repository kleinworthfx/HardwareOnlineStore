package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

/* AdminControllerTest.java
   Admin Controller Test
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminControllerTest {

    private static final AdminController controller = new AdminController();

    private static final Admin admin = new Admin.Builder()
            .setAdminId("ADM001")
            .setRole("Manager")
            .setPermissions("ALL")
            .build();

    @Test
    @Order(1)
    void create() {
        assertNotNull(controller.create(admin));
    }

    @Test
    @Order(2)
    void read() {
        assertEquals(admin.getAdminId(),
                controller.read(admin.getAdminId()).getAdminId());
    }

    @Test
    @Order(3)
    void update() {

        Admin updated = new Admin.Builder()
                .copy(admin)
                .setRole("Super Admin")
                .build();

        assertEquals("Super Admin",
                controller.update(updated).getRole());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(controller.delete(admin.getAdminId()));
    }
}