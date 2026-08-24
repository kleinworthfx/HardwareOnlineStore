package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Admin;
import za.ac.cput.service.AdminService;

import java.util.List;

/* AdminController.java
   Admin REST Controller
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService service;

    public AdminController(AdminService service) { this.service = service; }

    @GetMapping
    public List<Admin> getAll() { return service.getAll(); }

    @PostMapping
    public ResponseEntity<Admin> create(@RequestBody Admin entity) {
        return ResponseEntity.status(201).body(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> read(@PathVariable String id) {
        Admin entity = service.read(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@PathVariable String id, @RequestBody Admin entity) {
        Admin existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();
        Admin updated = Admin.copy(entity).id(existing.getId()).adminId(id).build();
        return ResponseEntity.ok(service.update(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
