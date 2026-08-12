package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

/* OrderItemFactory.java
   Factory class for creating OrderItem instances
   Author: Francine Mulangu Kasongo (230978649)
   Date: 28 June 2026 */
public class OrderItemFactory {

    public static OrderItem createOrderItem(String itemId, int quantity, double unitPrice) {

        if (Helper.isNullOrEmpty(itemId) || quantity <= 0 || unitPrice <= 0) {
            return null;
        }

        return new OrderItem.Builder()
                .setItemId(itemId)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .build();
    }
}