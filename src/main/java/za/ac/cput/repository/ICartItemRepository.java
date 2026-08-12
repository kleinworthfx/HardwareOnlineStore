package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.CartItem;

/* ICartItemRepository.java
   CartItem Repository Interface
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

public interface ICartItemRepository extends JpaRepository<CartItem, String> {
}
