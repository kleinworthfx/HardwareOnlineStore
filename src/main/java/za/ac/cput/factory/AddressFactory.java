package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

/* AddressFactory.java
   Address Factory Class
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/

public class AddressFactory {

    private AddressFactory() {
    }

    public static Address createAddress(String streetAddress,
                                        String suburb,
                                        String city,
                                        String postalCode) {

        if (Helper.isNullOrEmpty(streetAddress)) {
            throw new IllegalArgumentException("Street address is required.");
        }

        if (Helper.isNullOrEmpty(suburb)) {
            throw new IllegalArgumentException("Suburb is required.");
        }

        if (Helper.isNullOrEmpty(city)) {
            throw new IllegalArgumentException("City is required.");
        }

        if (Helper.isNullOrEmpty(postalCode)) {
            throw new IllegalArgumentException("Postal code is required.");
        }

        return new Address.Builder()
                .setStreetAddress(streetAddress)
                .setSuburb(suburb)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();
    }
}