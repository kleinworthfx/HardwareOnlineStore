package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.List;
/* CategoryController.java
   Category REST Controller
   Author: Sinoxolo Kobeni (230801846)
   Date: 19/07/2026
*/
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service = CategoryService.getService();

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @GetMapping("/read/{categoryId}")
    public Category read(@PathVariable String categoryId) {
        return service.read(categoryId);
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping("/delete/{categoryId}")
    public boolean delete(@PathVariable String categoryId) {
        return service.delete(categoryId);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return service.getAll();
    }
}