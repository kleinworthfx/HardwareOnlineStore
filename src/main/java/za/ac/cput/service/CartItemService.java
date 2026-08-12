package za.ac.cput.service;

import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.ICartItemRepository;

import java.util.List;

/* CartItemService.java
   Service Implementation for CartItem
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

public class CartItemService implements ICarItemService {

    private final ICartItemRepository repository;

    public CartItemService(ICartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public CartItem read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public List<CartItem> getAll() {
        return this.repository.findAll();
    }
}