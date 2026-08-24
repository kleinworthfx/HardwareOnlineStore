package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Customer;

import java.util.Optional;

/* ICustomerRepository.java
   Customer Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerId(String customerId);
    boolean existsByCustomerId(String customerId);
    void deleteByCustomerId(String customerId);
}
