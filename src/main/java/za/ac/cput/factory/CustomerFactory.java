package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

/* CustomerFactory.java
   Customer Factory Class
   Author: Paul Khumalo (230108547)
   Date: 28 June 2026
*/

public class CustomerFactory {

    private CustomerFactory() {
    }

    public static Customer createCustomer(String customerId,
                                          String name,
                                          String email,
                                          String passwordHash,
                                          Address shippingAddress,
                                          Address billingAddress) {

        if (Helper.isNullOrEmpty(customerId)) {
            throw new IllegalArgumentException("Customer ID is required");
        }

        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Customer name is required");
        }

        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("A valid email address is required");
        }

        if (Helper.isNullOrEmpty(passwordHash)) {
            throw new IllegalArgumentException("Password hash is required");
        }

        if (Helper.isNullOrEmpty(shippingAddress)) {
            throw new IllegalArgumentException("Shipping address is required");
        }

        if (Helper.isNullOrEmpty(billingAddress)) {
            throw new IllegalArgumentException("Billing address is required");
        }

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setName(name)
                .setEmail(email)
                .setPasswordHash(passwordHash)
                .setShippingAddress(shippingAddress)
                .setBillingAddress(billingAddress)
                .build();
    }
}