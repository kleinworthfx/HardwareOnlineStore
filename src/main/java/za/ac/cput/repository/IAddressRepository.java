package za.ac.cput.repository;


import za.ac.cput.entity.Address;

import java.util.List;

/* IAddressRepository.java
   Address Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface IAddressRepository extends IRepository<Address, String> {
   List<Address> getAll();
}