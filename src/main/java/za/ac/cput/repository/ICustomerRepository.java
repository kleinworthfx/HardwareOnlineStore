package za.ac.cput.repository;

import za.ac.cput.entity.Customer;

import java.util.List;

/* ICustomerRepository.java
   Customer Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface ICustomerRepository extends IRepository<Customer, String> {
  List<Customer> getAll();
}