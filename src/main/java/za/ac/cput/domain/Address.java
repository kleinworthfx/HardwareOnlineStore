package za.ac.cput.domain;

import za.ac.cput.util.Helper;

/* Address.java
   Address Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

public class Address {
    private final String streetAddress;
    private final String suburb;
    private final String city;
    private final String postalCode;

    private Address(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreetAddress() { return streetAddress; }
    public String getSuburb() { return suburb; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String streetAddress;
        private String suburb;
        private String city;
        private String postalCode;

        public Builder setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; return this; }
        public Builder setSuburb(String suburb) { this.suburb = suburb; return this; }
        public Builder setCity(String city) { this.city = city; return this; }
        public Builder setPostalCode(String postalCode) { this.postalCode = postalCode; return this; }

        public Builder copy(Address address) {
            this.streetAddress = address.streetAddress;
            this.suburb = address.suburb;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build() {
            if (Helper.isNullOrEmpty(streetAddress))
                throw new IllegalArgumentException("Street address is required");
            if (Helper.isNullOrEmpty(suburb))
                throw new IllegalArgumentException("Suburb is required");
            if (Helper.isNullOrEmpty(city))
                throw new IllegalArgumentException("City is required");
            if (Helper.isNullOrEmpty(postalCode))
                throw new IllegalArgumentException("Postal code is required");
            return new Address(this);
        }
    }
}