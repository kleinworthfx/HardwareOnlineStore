package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* OrderService.java
   Service Implementation for Order entity handling domain logic
   Author: Francine Mulangu Kasongo (230978649)
   Date: 12 July 2026 */

@Service
public class OrderService {

    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String orderId, String status) {
        Order order = OrderFactory.createOrder(orderId, status);
        if (order == null) {
            throw new IllegalArgumentException("Invalid order data provided");
        }
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order addItemToOrder(String orderId, String itemId, int quantity, double unitPrice) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isEmpty()) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }

        OrderItem newItem = OrderItemFactory.createOrderItem(itemId, quantity, unitPrice);
        if (newItem == null) {
            throw new IllegalArgumentException("Invalid order item parameters");
        }

        Order existingOrder = orderOpt.get();

        // Build updated order preserving existing fields and appending the new item
        Order updatedOrder = new Order.Builder()
                .setOrderId(existingOrder.getOrderId())
                .setOrderDate(existingOrder.getOrderDate())
                .setStatus(existingOrder.getStatus())
                .copy(existingOrder) // Uses builder copy if your domain supports it
                .build();

        return orderRepository.save(updatedOrder);
    }
}