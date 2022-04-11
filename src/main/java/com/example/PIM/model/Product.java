package com.example.PIM.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Products")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int id;
    public String title;
    public String description;
    public BigDecimal price;
    public int discount;
    public String image;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;


    public Product() {
    }

    public Product(int id, String title, String description, BigDecimal price, int discount, String image, LocalDateTime createdAt, LocalDateTime updatedAt, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.company = company;
    }

    public Product(String title, String description, BigDecimal price, int discount, String image, LocalDateTime createdAt, LocalDateTime updatedAt, Company company) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", company=" + company +
                '}';
    }
}
