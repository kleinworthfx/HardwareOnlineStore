package za.ac.cput.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.entity.Address;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

/* AddressService.java
   Address Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

@Service
@Transactional
public class AddressService implements IAddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Address> getAll() { return repository.findAll(); }

    public Address create(Address entity) {
        if (entity == null) throw new IllegalArgumentException("Address must not be null");
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Address read(Long id) { return repository.findById(id).orElse(null); }

    public Address update(Address entity) {
        if (entity == null) throw new IllegalArgumentException("Address must not be null");
        Long existingId;
        if (entity.getId() == null) throw new ResourceNotFoundException("Address id is required");
        existingId = entity.getId();
        if (!repository.existsById(existingId)) throw new ResourceNotFoundException("Address not found: " + existingId);
        return repository.save(Address.copy(entity).id(existingId).build());
    }

    public boolean delete(Long id) {
        if (!(repository.existsById(id))) return false;
        repository.deleteById(id);
        return true;
    }
}
