package za.ac.cput.service;

import za.ac.cput.domain.Category;

import java.util.Set;
/* ICategoryService.java
   Category Service Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public interface ICategoryService extends IService<Category, String> {

    boolean delete(String categoryId);

    Set<Category> getAll();

}