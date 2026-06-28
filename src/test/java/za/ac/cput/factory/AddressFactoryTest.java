package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

/* AddressFactoryTest.java
   Address Factory Test
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/

class AddressFactoryTest {

    @Test
    void createAddress() {

        Address address = AddressFactory.createAddress(
                "15 Long Street",
                "Cape Town CBD",
                "Cape Town",
                "8001"
        );

        assertNotNull(address);
        assertEquals("15 Long Street", address.getStreetAddress());
        assertEquals("Cape Town CBD", address.getSuburb());
        assertEquals("Cape Town", address.getCity());
        assertEquals("8001", address.getPostalCode());

        System.out.println(address);
    }

    @Test
    void createAddressWithNullStreetAddress() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AddressFactory.createAddress(
                        null,
                        "Cape Town CBD",
                        "Cape Town",
                        "8001")
        );

        assertEquals("Street address is required.", exception.getMessage());
    }

    @Test
    void createAddressWithEmptySuburb() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AddressFactory.createAddress(
                        "15 Long Street",
                        "",
                        "Cape Town",
                        "8001")
        );

        assertEquals("Suburb is required.", exception.getMessage());
    }

    @Test
    void createAddressWithEmptyCity() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AddressFactory.createAddress(
                        "15 Long Street",
                        "Cape Town CBD",
                        "",
                        "8001")
        );

        assertEquals("City is required.", exception.getMessage());
    }

    @Test
    void createAddressWithEmptyPostalCode() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> AddressFactory.createAddress(
                        "15 Long Street",
                        "Cape Town CBD",
                        "Cape Town",
                        "")
        );

        assertEquals("Postal code is required.", exception.getMessage());
    }

    // Intentionally failing test
    @Test
    void failingTest() {

        Address address = AddressFactory.createAddress(
                "15 Long Street",
                "Cape Town CBD",
                "Cape Town",
                "8001"
        );

        // This assertion is intentionally incorrect.
        assertEquals("Johannesburg", address.getCity());
    }
}