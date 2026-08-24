package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.CartItem;
import static org.junit.jupiter.api.Assertions.*;

/* CartItemFactoryTest.java
   TDD Unit Tests for CartItem Factory
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
class CartItemFactoryTest {

    @Test
    void testCreateCartItemSuccess() {
        CartItem item = CartItemFactory.createCartItem("CI-001", "CART-501", "PROD-202", 3);
        assertNotNull(item);
        assertEquals("CI-001", item.getCartItemId());
        assertEquals(3, item.getQuantity());
    }

    @Test
    void testCreateCartItemWithZeroQuantityReturnsNull() {
        CartItem item = CartItemFactory.createCartItem("CI-001", "CART-501", "PROD-202", 0);
        assertNull(item);
    }
}

