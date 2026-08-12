package za.ac.cput.service;

import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;
/* ProductService.java
   Product Service Implementation using Singleton Pattern
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public class ProductService implements IProductService {

    private static ProductService service = null;
    private final ProductRepository repository;

    private ProductService() {
        repository = ProductRepository.getRepository();
    }

    public static ProductService getService() {
        if (service == null) {
            service = new ProductService();
        }
        return service;
    }

    @Override
    public Product create(Product product) {
        return repository.create(product);
    }

    @Override
    public Product read(String productId) {
        return repository.read(productId);
    }

    @Override
    public Product update(Product product) {
        return repository.update(product);
    }

    @Override
    public boolean delete(String productId) {
        return repository.delete(productId);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }
}