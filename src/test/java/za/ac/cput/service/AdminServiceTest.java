package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

/* AdminServiceTest.java
   Admin Service Test
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminServiceTest {

    private static final AdminService service = AdminService.getService();

    private static final Admin admin = new Admin.Builder()
            .setAdminId("ADM001")
            .setRole("System Administrator")
            .setPermissions("ALL")
            .build();

    @Test
    @Order(1)
    void create() {
        assertNotNull(service.create(admin));
    }

    @Test
    @Order(2)
    void read() {
        Admin read = service.read(admin.getAdminId());
        assertNotNull(read);
        assertEquals(admin.getAdminId(), read.getAdminId());
    }

    @Test
    @Order(3)
    void update() {
        Admin updated = new Admin.Builder()
                .copy(admin)
                .setRole("Super Admin")
                .build();

        Admin result = service.update(updated);
        assertNotNull(result);
        assertEquals("Super Admin", result.getRole());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(service.delete(admin.getAdminId()));
    }
}