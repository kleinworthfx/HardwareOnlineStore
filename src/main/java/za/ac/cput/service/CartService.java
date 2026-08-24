package za.ac.cput.service;

import za.ac.cput.entity.Cart;

import java.util.List;

/* CartService.java
   Cart Service Implementation using Singleton Pattern
   Author: Mfanafuthi Khumalo 230018270
   Date: 12 July 2026 */
public class CartService implements ICartService {
    private static CartService service = null;
    private final CartRepository repository;

    private CartService() {
        // Assumes a CartRepository with a .getRepository() singleton exists
        this.repository = CartRepository.getRepository();
    }

    public static CartService getService() {
        if (service == null) {
            service = new CartService();
        }
        return service;
    }

    @Override
    public Cart create(Cart cart) {
        return repository.create(cart);
    }

    @Override
    public Cart read(String cartId) {
        return repository.read(cartId);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.update(cart);
    }

    @Override
    public List<Cart> getAll() {
        return repository.getAll();
    }
}