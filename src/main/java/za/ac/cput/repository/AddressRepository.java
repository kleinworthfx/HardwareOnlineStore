package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Address;

/* IAddressRepository.java
   Address Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface AddressRepository extends JpaRepository<Address, Long> {

}
