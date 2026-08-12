package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.Set;
/* IProductService.java
   Product Service Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public interface IProductService extends IService<Product, String> {

    boolean delete(String productId);

    Set<Product> getAll();

}