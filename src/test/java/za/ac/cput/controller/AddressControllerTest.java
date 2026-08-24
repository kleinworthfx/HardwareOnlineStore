package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Address;

import static org.junit.jupiter.api.Assertions.*;

/* AddressControllerTest.java
   Address Controller Test
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressControllerTest {

    private static final AddressController controller = new AddressController();

    private static final Address address = new Address.Builder()
            .setStreetAddress("12 Vilakazi Street")
            .setSuburb("Orlando West")
            .setCity("Soweto")
            .setPostalCode("1804")
            .build();

    @Test
    @Order(1)
    void create() {
        Address created = controller.create(address);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Address read = controller.read(address.getStreetAddress());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {
        Address updated = new Address.Builder()
                .copy(address)
                .setCity("Johannesburg")
                .build();

        assertEquals("Johannesburg",
                controller.update(updated).getCity());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(controller.delete(address.getStreetAddress()));
    }
}