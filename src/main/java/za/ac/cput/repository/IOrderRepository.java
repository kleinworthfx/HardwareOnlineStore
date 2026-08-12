package za.ac.cput.repository;

import za.ac.cput.domain.Order;
import java.util.List;
import java.util.Optional;

/* IOrderRepository.java
   Repository Interface for Order Entity
   Author: Francine Mulangu Kasongo (230978649)
   Date: 12 July 2026 */
public interface IOrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
    List<Order> findAll();
    void deleteById(String orderId);
}