package za.ac.cput.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

import java.util.Objects;

/* Address.java
   Address Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

@Entity
@Table(name = "address")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="street_address", nullable=false, length=255)
    private String streetAddress;
    @Column(nullable=false, length=255)
    private String suburb;
    @Column(nullable=false, length=255)
    private String city;
    @Column(name="postal_code", nullable=false, length=255)
    private String postalCode;

    protected Address() {
    }

    private Address(Builder builder) {
        this.id = builder.id;
        this.streetAddress = builder.streetAddress;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public Long getId() { return id; }
    public String getStreetAddress() { return streetAddress; }
    public String getSuburb() { return suburb; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    public static Builder builder() { return new Builder(); }

    public static Builder copy(Address entity) {
        return new Builder()
                .id(entity.id)
                .streetAddress(entity.getStreetAddress())
                .suburb(entity.getSuburb())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode());
    }

    public static final class Builder {
        private Long id;
        private String streetAddress;
        private String suburb;
        private String city;
        private String postalCode;
        public Builder id(Long id) { this.id = id; return this; }
        public Builder streetAddress(String streetAddress) { this.streetAddress = streetAddress; return this; }
        public Builder suburb(String suburb) { this.suburb = suburb; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder postalCode(String postalCode) { this.postalCode = postalCode; return this; }
        public Address build() {
            if (streetAddress == null) throw new IllegalArgumentException("streetAddress is required");
            if (suburb == null) throw new IllegalArgumentException("suburb is required");
            if (city == null) throw new IllegalArgumentException("city is required");
            if (postalCode == null) throw new IllegalArgumentException("postalCode is required");

            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address other)) return false;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }

    @Override
    public String toString() { return "Address" + "{id=" + id + "}"; }
}
