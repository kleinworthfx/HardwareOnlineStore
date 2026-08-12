package za.ac.cput.repository;

import za.ac.cput.domain.Product;

import java.util.Set;
/* IProductRepository.java
   Product Repository Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 05 July 2026 */


public interface IProductRepository extends IRepository<Product, String> {

    Set<Product> getAll();

}