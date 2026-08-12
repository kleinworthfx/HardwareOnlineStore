package za.ac.cput.repository;

import za.ac.cput.domain.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* CategoryRepository.java
   Category Repository Implementation
   Author: Sinoxolo Kobeni (230801846)
   Date: 5 June 2026 */

public class CategoryRepository implements ICategoryRepository {

    private static CategoryRepository repository = null;

    private final List<Category> categoryDB;

    private CategoryRepository() {
        categoryDB = new ArrayList<>();
    }

    public static CategoryRepository getRepository() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    @Override
    public Category create(Category category) {
        categoryDB.add(category);
        return category;
    }

    @Override
    public Category read(String categoryId) {

        for (Category category : categoryDB) {

            if (category.getCategoryId().equals(categoryId)) {
                return category;
            }
        }

        return null;
    }

    @Override
    public Category update(Category category) {

        Category oldCategory = read(category.getCategoryId());

        if (oldCategory != null) {
            categoryDB.remove(oldCategory);
            categoryDB.add(category);
            return category;
        }

        return null;
    }

    @Override
    public boolean delete(String categoryId) {

        Category category = read(categoryId);

        if (category != null) {
            categoryDB.remove(category);
            return true;
        }

        return false;
    }

    public List<Category> getAll() {
        return categoryDB;
    }
}