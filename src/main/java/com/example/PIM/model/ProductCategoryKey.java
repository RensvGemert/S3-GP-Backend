package com.example.PIM.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductCategoryKey implements Serializable
{
    @Column(name = "productId")
    public int productId;

    @Column(name = "categoryId")
    public int categoryId;

    public ProductCategoryKey(int productId, int categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public ProductCategoryKey(){

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


}
