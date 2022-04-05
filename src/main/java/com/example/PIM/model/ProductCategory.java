package com.example.PIM.model;

import javax.persistence.*;

@Entity
public class ProductCategory
{
    @EmbeddedId
    public ProductCategoryKey  id;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "categoryId")
    public Category category;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    public Product product;

    public ProductCategory(ProductCategoryKey id, Category category, Product product) {
        this.id = id;
        this.category = category;
        this.product = product;
    }

    public ProductCategory(){

    }

    public ProductCategoryKey getId() {
        return id;
    }

    public void setId(ProductCategoryKey id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
