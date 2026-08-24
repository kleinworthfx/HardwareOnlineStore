package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Customer;
import za.ac.cput.service.CustomerService;

import java.util.List;

/* CustomerController.java
   Customer REST Controller
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) { this.service = service; }

    @GetMapping
    public List<Customer> getAll() { return service.getAll(); }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer entity) {
        return ResponseEntity.status(201).body(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> read(@PathVariable String id) {
        Customer entity = service.read(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable String id, @RequestBody Customer entity) {
        Customer existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();
        Customer updated = Customer.copy(entity).id(existing.getId()).customerId(id).build();
        return ResponseEntity.ok(service.update(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
