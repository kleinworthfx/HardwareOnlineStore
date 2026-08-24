package za.ac.cput.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.entity.Customer;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

/* CustomerService.java
   Customer Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@Service
@Transactional
public class CustomerService implements ICustomerService{
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Customer> getAll() { return repository.findAll(); }

    public Customer create(Customer entity) {
        if (entity == null) throw new IllegalArgumentException("Customer must not be null");
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Customer read(String id) { return repository.findByCustomerId(id).orElse(null); }

    public Customer update(Customer entity) {
        if (entity == null) throw new IllegalArgumentException("Customer must not be null");
        Long existingId;
        Customer existing = repository.findByCustomerId(entity.getCustomerId()).orElse(null);
        if (existing == null) throw new ResourceNotFoundException("Customer not found: " + entity.getCustomerId());
        existingId = existing.getId();
        return repository.save(Customer.copy(entity).id(existingId).build());
    }

    public boolean delete(String id) {
        if (!(repository.existsByCustomerId(id))) return false;
        repository.deleteByCustomerId(id);
        return true;
    }
}
