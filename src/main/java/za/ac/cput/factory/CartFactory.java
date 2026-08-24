package za.ac.cput.factory;

import za.ac.cput.entity.Cart;

import java.util.Date;

/* CartFactory.java
   Factory class for Cart Entity
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
public class CartFactory {

    public static Cart createCart(String cartId, String customerId, Date lastUpdated) {
        if (Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(customerId) || lastUpdated == null) {
            return null;
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomerId(customerId)
                .setLastUpdated(lastUpdated)
                .build();
    }
}
