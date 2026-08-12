package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import java.util.ArrayList;
import java.util.List;

/* CartRepository.java
   Cart Repository Implementation utilizing Singleton Pattern
   Author: Mfanafuthi Khumalo (230018270)
   Date: 12 July 2026 */
public class CartRepository implements ICartRepository {

    private static CartRepository repository = null;
    private final List<Cart> cartList;

    private CartRepository() {
        this.cartList = new ArrayList<>();
    }

    // Singleton instance access point expected by CartService
    public static CartRepository getRepository() {
        if (repository == null) {
            repository = new CartRepository();
        }
        return repository;
    }

    @Override
    public Cart create(Cart cart) {
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        for (Cart cart : this.cartList) {
            if (cart.getCartId().equals(cartId)) {
                return cart;
            }
        }
        return null;
    }

    @Override
    public Cart update(Cart cart) {
        Cart oldCart = read(cart.getCartId());
        if (oldCart != null) {
            this.cartList.remove(oldCart);
            this.cartList.add(cart);
            return cart;
        }
        return null;
    }

    @Override
    public boolean delete(String cartId) {
        Cart cartToDelete = read(cartId);
        if (cartToDelete != null) {
            return this.cartList.remove(cartToDelete);
        }
        return false;
    }

    @Override
    public List<Cart> getAll() {
        return this.cartList;
    }
}
