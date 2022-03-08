package com.example.PIM.model;

public class Product {
    public Integer productId;
    public String productTitle;
    public String productDescription;

    public Product() {
    }

    public Product(Integer productId, String productTitle, String productDescription) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
