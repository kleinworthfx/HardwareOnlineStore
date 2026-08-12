package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Inventory;
import java.util.List;

/* IInventoryRepository.java
   Inventory-specific Repository Interface
   Author: [Khonzinkosi Khumalo] 230231802
   Date: 05 July 2026 */
@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, String> {
    // Contract to fetch all tracked stock lines
}
