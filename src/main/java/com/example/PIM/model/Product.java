package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Products")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int productId;
    public String productTitle;
    public String productDescription;
    public int productPrice;
    public int productDiscount;
    public String productImage;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    public Product() {
    }

    public Product(int productId, String productTitle, String productDescription, int productPrice, int productDiscount, String productImage, LocalDateTime createdAt, LocalDateTime updatedAt, Company company) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productImage = productImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.company = company;
    }

    public Product(String productTitle, String productDescription, int productPrice, int productDiscount, String productImage, LocalDateTime createdAt, LocalDateTime updatedAt, Company company) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productImage = productImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.company = company;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productDiscount=" + productDiscount +
                ", productImage='" + productImage + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", company=" + company +
                '}';
    }
}
