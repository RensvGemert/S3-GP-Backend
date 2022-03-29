package com.example.PIM.model;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer productId;
    public String productTitle;
    public String productDescription;

    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    public Product() {
    }

    public Product(Integer productId, String productTitle, String productDescription, Company company) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
