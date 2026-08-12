package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // <-- Make sure this import is present
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.IInventoryRepository;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {

    private final IInventoryRepository repository;

    @Autowired
    public InventoryService(IInventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Inventory read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public List<Inventory> getAll() {
        return this.repository.findAll();
    }
}