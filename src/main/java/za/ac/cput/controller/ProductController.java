package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.ProductService;

import java.util.List;
/* ProductController.java
   Product REST Controller
   Author: Sinoxolo Kobeni (230801846)
   Date: 19/07/2026
*/
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service = ProductService.getService();

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping("/read/{productId}")
    public Product read(@PathVariable String productId) {
        return service.read(productId);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable String productId) {
        return service.delete(productId);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return service.getAll();
    }
}
