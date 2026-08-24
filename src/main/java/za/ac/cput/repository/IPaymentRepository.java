package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Payment;

/* IPaymentRepository.java
   Payment-specific Repository Interface
   Author: [Khonzinkosi Khumalo] 230231802
   Date: 05 July 2026 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, String> {
    // Contract to fetch all tracked stock lines
}
