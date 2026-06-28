package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;

/* AdminFactoryTest.java
   Admin Factory Test
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/

class AdminFactoryTest {

    @Test
    void createAdmin() {

        Admin admin = AdminFactory.createAdmin(
                "ADM001",
                "System Administrator",
                "READ, WRITE, UPDATE, DELETE"
        );

        assertNotNull(admin);
        assertEquals("ADM001", admin.getAdminId());
        assertEquals("System Administrator", admin.getRole());
        assertEquals("READ, WRITE, UPDATE, DELETE", admin.getPermissions());

        System.out.println(admin);
    }

    @Test
    void createAdminWithNullAdminId() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AdminFactory.createAdmin(
                        null,
                        "System Administrator",
                        "ALL")
        );

        assertEquals("Admin system identity authorization key required",
                exception.getMessage());
    }

    @Test
    void createAdminWithEmptyRole() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AdminFactory.createAdmin(
                        "ADM001",
                        "",
                        "ALL")
        );

        assertEquals("Admin role is required",
                exception.getMessage());
    }

    @Test
    void createAdminWithEmptyPermissions() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AdminFactory.createAdmin(
                        "ADM001",
                        "Manager",
                        "")
        );

        assertEquals("Admin permissions are required",
                exception.getMessage());
    }

    // Deliberately failing test
    @Test
    void failingTest() {

        Admin admin = AdminFactory.createAdmin(
                "ADM001",
                "System Administrator",
                "ALL"
        );

        // This assertion is intentionally incorrect.
        assertEquals("ADM999", admin.getAdminId());
    }
}