package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Cart;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/* CartFactoryTest.java
   TDD Unit Tests for Cart Factory
   Author: Mfanafuthi Khumalo 230018270
   Date: 28 June 2026 */
class CartFactoryTest {

    @Test
    void testCreateCartSuccess() {
        Cart cart = CartFactory.createCart("CART-501", "CUST-9921", new Date());
        assertNotNull(cart);
        assertEquals("CART-501", cart.getCartId());
        assertEquals("CUST-9921", cart.getCustomerId());
    }

    @Test
    void testCreateCartWithMissingCustomerIdReturnsNull() {
        Cart cart = CartFactory.createCart("CART-501", "", new Date());
        assertNull(cart);
    }
}
