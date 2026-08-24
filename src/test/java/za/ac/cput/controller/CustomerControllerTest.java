package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Address;
import za.ac.cput.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

/* CustomerControllerTest.java
   Customer Controller Test
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTest {

    private static final CustomerController controller = new CustomerController();

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
        assertNotNull(controller.create(customer));
    }

    @Test
    @Order(2)
    void read() {
        Customer read = controller.read(customer.getCustomerId());
        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Customer updated = new Customer.Builder()
                .copy(customer)
                .setName("Sibusiso Dlamini")
                .build();

        assertEquals("Sibusiso Dlamini",
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
        assertTrue(controller.delete(customer.getCustomerId()));
    }
}