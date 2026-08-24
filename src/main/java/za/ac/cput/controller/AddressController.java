package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Address;
import za.ac.cput.service.AddressService;

import java.util.List;

/* AddressController.java
   Address REST Controller
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService service;

    public AddressController(AddressService service) { this.service = service; }

    @GetMapping
    public List<Address> getAll() { return service.getAll(); }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address entity) {
        return ResponseEntity.status(201).body(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> read(@PathVariable Long id) {
        Address entity = service.read(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address entity) {
        Address existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();
        Address updated = Address.copy(entity).id(existing.getId()).build();
        return ResponseEntity.ok(service.update(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
