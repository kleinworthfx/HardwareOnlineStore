package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import za.ac.cput.entity.Customer;

/* CustomerFactory.java
   Customer Factory Class
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/


public class CustomerFactory {
    private CustomerFactory() {}

    public static Customer create(String customerId, String name, String email, String passwordHash, Address shippingAddress, Address billingAddress) {
        return Customer.builder()
                .customerId(customerId)
                .name(name)
                .email(email)
                .passwordHash(passwordHash)
                .shippingAddress(shippingAddress)
                .billingAddress(billingAddress)
                .build();
    }
}
