package za.ac.cput.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.entity.Admin;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.repository.AdminRepository;

import java.util.List;

/* AdminService.java
   Admin Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@Service
@Transactional
public class AdminService implements IAdminService{
    private final AdminRepository repository;

    public AdminService(AdminRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Admin> getAll() { return repository.findAll(); }

    public Admin create(Admin entity) {
        if (entity == null) throw new IllegalArgumentException("Admin must not be null");
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Admin read(String id) { return repository.findByAdminId(id).orElse(null); }

    public Admin update(Admin entity) {
        if (entity == null) throw new IllegalArgumentException("Admin must not be null");
        Long existingId;
        Admin existing = repository.findByAdminId(entity.getAdminId()).orElse(null);
        if (existing == null) throw new ResourceNotFoundException("Admin not found: " + entity.getAdminId());
        existingId = existing.getId();
        return repository.save(Admin.copy(entity).id(existingId).build());
    }

    public boolean delete(String id) {
        if (!(repository.existsByAdminId(id))) return false;
        repository.deleteByAdminId(id);
        return true;
    }
}
