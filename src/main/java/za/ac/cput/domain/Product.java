
package za.ac.cput.domain;

import java.math.BigDecimal;
/*
 * Product.java
 * Product Domain Entity using Builder Pattern
 * Author: Sinoxolo Kobeni (230801846)
 * Date: 21 June 2026
 */

public class Product {

    private final String productId;
    private final String categoryId;
    private final String name;
    private final String sku;
    private final String description;
    private final BigDecimal price;
    private final double weight;
    private final String dimensions;
    private final String imageUrl;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.sku = builder.sku;
        this.description = builder.description;
        this.price = builder.price;
        this.weight = builder.weight;
        this.dimensions = builder.dimensions;
        this.imageUrl = builder.imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public static class Builder {

        private String productId;
        private String categoryId;
        private String name;
        private String sku;
        private String description;
        private BigDecimal price;
        private double weight;
        private String dimensions;
        private String imageUrl;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSku(String sku) {
            this.sku = sku;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setDimensions(String dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.categoryId = product.categoryId;
            this.name = product.name;
            this.sku = product.sku;
            this.description = product.description;
            this.price = product.price;
            this.weight = product.weight;
            this.dimensions = product.dimensions;
            this.imageUrl = product.imageUrl;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
