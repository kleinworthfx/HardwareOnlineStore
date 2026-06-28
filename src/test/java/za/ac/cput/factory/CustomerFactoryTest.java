package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

/* CustomerFactoryTest.java
   Customer Factory Test
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/

class CustomerFactoryTest {

    private final Address shipping = new Address.Builder()
            .setStreetAddress("10 Main Road")
            .setSuburb("Bellville")
            .setCity("Cape Town")
            .setPostalCode("7530")
            .build();

    private final Address billing = new Address.Builder()
            .setStreetAddress("20 Church Street")
            .setSuburb("CBD")
            .setCity("Cape Town")
            .setPostalCode("8001")
            .build();

    @Test
    void createCustomer() {

        Customer customer = CustomerFactory.createCustomer(
                "C001",
                "Paul Khumalo",
                "Paul@gmail.com",
                "hash123",
                shipping,
                billing
        );

        assertNotNull(customer);
        assertEquals("C001", customer.getCustomerId());
        assertEquals("Paul Khumalo", customer.getName());
        assertEquals("Paul@gmail.com", customer.getEmail());

        System.out.println(customer);
    }

    @Test
    void createCustomerWithInvalidEmail() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> CustomerFactory.createCustomer(
                        "C001",
                        "Paul Khumalo",
                        "invalid-email",
                        "hash123",
                        shipping,
                        billing
                )
        );

        assertEquals("A valid email address is required", exception.getMessage());
    }

    @Test
    void createCustomerWithNullName() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> CustomerFactory.createCustomer(
                        "C001",
                        null,
                        "Paul@gmail.com",
                        "hash123",
                        shipping,
                        billing
                )
        );

        assertEquals("Customer name is required", exception.getMessage());
    }

    @Test
    void createCustomerWithNullShippingAddress() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> CustomerFactory.createCustomer(
                        "C001",
                        "Paul Khumalo",
                        "Paul@gmail.com",
                        "hash123",
                        null,
                        billing
                )
        );

        assertEquals("Shipping address is required", exception.getMessage());
    }

    // Failing test
    @Test
    void failingTest() {

        Customer customer = CustomerFactory.createCustomer(
                "C001",
                "Paul Khumalo",
                "Paul@gmail.com",
                "hash123",
                shipping,
                billing
        );

        // Wrong expected value test will fail
        assertEquals("C999", customer.getCustomerId());
    }
}