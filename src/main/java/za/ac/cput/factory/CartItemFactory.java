package za.ac.cput.factory;

import za.ac.cput.entity.CartItem;

/* CartItemFactory.java
   Factory class for CartItem Entity
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
public class CartItemFactory {

    public static CartItem createCartItem(String cartItemId, String cartId, String productId, int quantity) {
        if (Helper.isNullOrEmpty(cartItemId) || Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(productId)) {
            return null;
        }
        if (quantity <= 0) {
            return null;
        }

        return new CartItem.Builder()
                .setCartItemId(cartItemId)
                .setCartId(cartId)
                .setProductId(productId)
                .setQuantity(quantity)
                .build();
    }
}
