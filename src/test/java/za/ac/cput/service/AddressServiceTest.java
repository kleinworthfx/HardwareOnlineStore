package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Address;

import static org.junit.jupiter.api.Assertions.*;

/* AddressServiceTest.java
   Address Service Test
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressServiceTest {

    private static final AddressService service = AddressService.getService();

    private static final Address address = new Address.Builder()
            .setStreetAddress("12 Vilakazi Street")
            .setSuburb("Orlando West")
            .setCity("Soweto")
            .setPostalCode("1804")
            .build();

    @Test
    @Order(1)
    void create() {
        Address created = service.create(address);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Address read = service.read(address.getStreetAddress());
        assertNotNull(read);
        assertEquals(address.getStreetAddress(), read.getStreetAddress());
    }

    @Test
    @Order(3)
    void update() {
        Address updated = new Address.Builder()
                .copy(address)
                .setCity("Johannesburg")
                .build();

        Address result = service.update(updated);
        assertNotNull(result);
        assertEquals("Johannesburg", result.getCity());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(service.delete(address.getStreetAddress()));
    }
}