package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/* OrderFactory.java
   Factory class for creating Order instances
   Author: Francine Mulangu Kasongo (230978649)
   Date: 28 June 2026 */
public class OrderFactory {

    public static Order createOrder(String orderId, String status) {
        if (Helper.isNullOrEmpty(orderId) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(LocalDate.now())
                .setStatus(status)
                .build();
    }
}