package com.example.PIM.model;

import javax.persistence.*;

@Entity
public class ProductField {
    @EmbeddedId
    public ProductFieldKey  id;

    @ManyToOne
    @MapsId("fieldId")
    @JoinColumn(name = "fieldId")
    public Field field;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    public Product product;

    public String value;

    public ProductField(ProductFieldKey id, Field field, Product product, String value) {
        this.id = id;
        this.field = field;
        this.product = product;
        this.value = value;
    }

    public ProductField(Field field, Product product, String value) {
        this.field = field;
        this.product = product;
        this.value = value;
    }

    public ProductField()
    {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductFieldKey getId() {
        return id;
    }

    public void setId(ProductFieldKey id) {
        this.id = id;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
