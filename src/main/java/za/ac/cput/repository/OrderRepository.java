package za.ac.cput.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Optional;

/* OrderRepositoryImpl.java
   Order Repository Implementation utilizing JPA EntityManager
   Author: Francine Mulangu Kasongo (230978649)
   Date: 12 July 2026 */

@Repository
public class OrderRepository implements IOrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order save(Order order) {
        if (order.getOrderId() == null || order.getOrderId().isEmpty()) {
            em.persist(order);
            return order;
        } else {
            return em.merge(order);
        }
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(em.find(Order.class, orderId));
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public void deleteById(String orderId) {
        Order order = em.find(Order.class, orderId);
        if (order != null) {
            em.remove(order);
        }
    }
}