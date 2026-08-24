package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Address;
import za.ac.cput.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

/* CustomerServiceTest.java
   Customer Service Test
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {

    private static final CustomerService service = CustomerService.getService();

    private static final Address address = new Address.Builder()
            .setStreetAddress("45 Chris Hani Road")
            .setSuburb("Diepkloof")
            .setCity("Soweto")
            .setPostalCode("1862")
            .build();

    private static final Customer customer = new Customer.Builder()
            .setCustomerId("CUS001")
            .setName("Sipho Dlamini")
            .setEmail("sipho@gmail.com")
            .setPasswordHash("123456")
            .setShippingAddress(address)
            .setBillingAddress(address)
            .build();

    @Test
    @Order(1)
    void create() {
        assertNotNull(service.create(customer));
    }

    @Test
    @Order(2)
    void read() {
        Customer read = service.read(customer.getCustomerId());
        assertNotNull(read);
        assertEquals(customer.getCustomerId(), read.getCustomerId());
    }

    @Test
    @Order(3)
    void update() {
        Customer updated = new Customer.Builder()
                .copy(customer)
                .setName("Sibusiso Dlamini")
                .build();

        Customer result = service.update(updated);
        assertNotNull(result);
        assertEquals("Sibusiso Dlamini", result.getName());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(service.delete(customer.getCustomerId()));
    }
}