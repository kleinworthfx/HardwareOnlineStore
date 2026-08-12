package za.ac.cput.service;

import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoryRepository;

import java.util.List;
import java.util.Set;
/* CategoryService.java
   Category Service Implementation using Singleton Pattern
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public class CategoryService implements ICategoryService {

    private static CategoryService service = null;
    private final CategoryRepository repository;

    private CategoryService() {
        repository = CategoryRepository.getRepository();
    }

    public static CategoryService getService() {
        if (service == null) {
            service = new CategoryService();
        }
        return service;
    }

    @Override
    public Category create(Category category) {
        return repository.create(category);
    }

    @Override
    public Category read(String categoryId) {
        return repository.read(categoryId);
    }

    @Override
    public Category update(Category category) {
        return repository.update(category);
    }

    @Override
    public boolean delete(String categoryId) {
        return repository.delete(categoryId);
    }

    @Override
    public List<Category> getAll() {
        return repository.getAll();
    }
}