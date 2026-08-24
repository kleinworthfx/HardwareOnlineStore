package za.ac.cput.factory;

import za.ac.cput.entity.Address;

/* AddressFactory.java
   Address Factory Class
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/


public class AddressFactory {
    private AddressFactory() {}

    public static Address create(String streetAddress, String suburb, String city, String postalCode) {
        return Address.builder()
                .streetAddress(streetAddress)
                .suburb(suburb)
                .city(city)
                .postalCode(postalCode)
                .build();
    }
}
