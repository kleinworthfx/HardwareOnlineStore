package za.ac.cput.repository;

import za.ac.cput.domain.Category;

import java.util.Set;
/* ICategoryRepository.java
   Category Repository Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 05 July 2026 */

public interface ICategoryRepository extends IRepository<Category, String> {

    Set<Category> getAll();

}