package za.ac.cput.factory;
import za.ac.cput.entity.Product;

import java.math.BigDecimal;

/* ProductFactory.java
   Product Factory Class
   Author: Sinoxolo Kobeni (230801846)
   Date: 28 June 2026
*/
public class ProductFactory {
    public static Product createProduct(String productId,
                                        String categoryId,
                                        String name,
                                        String sku,
                                        String description,
                                        BigDecimal price,
                                        double weight,
                                        String dimensions,
                                        String imageUrl) {

        if (Helper.isNullOrEmpty(productId)
                || Helper.isNullOrEmpty(categoryId)
                || Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(sku)
                || price == null
                || price.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }

        return new Product.Builder()
                .setProductId(productId)
                .setCategoryId(categoryId)
                .setName(name)
                .setSku(sku)
                .setDescription(description)
                .setPrice(price)
                .setWeight(weight)
                .setDimensions(dimensions)
                .setImageUrl(imageUrl)
                .build();
    }
}
