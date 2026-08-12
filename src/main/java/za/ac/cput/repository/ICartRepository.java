package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import java.util.List;

/* ICartRepository.java
   Repository Interface for Cart Entity
   Author: Mfanafuthi Khumalo (230018270)
   Date: 12 July 2026 */
public interface ICartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    Cart update(Cart cart);
    boolean delete(String cartId);
    List<Cart> getAll();
}