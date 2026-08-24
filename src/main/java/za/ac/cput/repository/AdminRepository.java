package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Admin;

import java.util.Optional;

/* IAdminRepository.java
   Admin Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminId(String adminId);
    boolean existsByAdminId(String adminId);
    void deleteByAdminId(String adminId);
}
