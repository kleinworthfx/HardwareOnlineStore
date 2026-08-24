package za.ac.cput.factory;

import za.ac.cput.entity.Category;

/* CategoryFactory.java
   Category Factory Class
   Author: Sinoxolo Kobeni (230801846)
   Date: 28 June 2026
*/

public class CategoryFactory {
    public static Category createCategory(String categoryId,
                                          String name,
                                          String parentId) {

        if (Helper.isNullOrEmpty(categoryId)
                || Helper.isNullOrEmpty(name)) {
            return null;
        }

        return new Category.Builder()
                .setCategoryId(categoryId)
                .setName(name)
                .setParentId(parentId)
                .build();
    }

}
