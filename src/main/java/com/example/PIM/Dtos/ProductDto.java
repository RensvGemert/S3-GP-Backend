package com.example.PIM.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDto
{
    public int id;
    public String title;
    public String description;
    public BigDecimal price;
    public int discount;
    public String image;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public List<ProductFieldDto> productFields = new ArrayList<>();
    public int companyId;

    public ProductDto(int id, String title, String description, BigDecimal price, int discount, String image, LocalDateTime createdAt, LocalDateTime updatedAt, List<ProductFieldDto> productFields, int companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productFields = productFields;
        this.companyId = companyId;
    }

    public ProductDto(String title, String description, BigDecimal price, int discount, String image, LocalDateTime createdAt, LocalDateTime updatedAt, List<ProductFieldDto> productFields, int companyId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productFields = productFields;
        this.companyId = companyId;
    }

    public ProductDto(){

    }

    public ProductDto(int id, String title, String description, BigDecimal price, int discount, String image, LocalDateTime createdAt, LocalDateTime updatedAt, List<ProductFieldDto> productFields) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productFields = productFields;
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

    public List<ProductFieldDto> getProductFields() {
        return productFields;
    }

    public void setProductFields(List<ProductFieldDto> productFields) {
        this.productFields = productFields;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && discount == that.discount && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(image, that.image) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(productFields, that.productFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, discount, image, createdAt, updatedAt, productFields);
    }
}
