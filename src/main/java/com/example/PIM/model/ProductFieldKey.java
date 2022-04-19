package com.example.PIM.model;

import javax.persistence.Column;
import java.io.Serializable;

public class ProductFieldKey implements Serializable {

    @Column(name = "productId")
    public int productId;

    @Column(name = "fieldId")
    public int fieldId;

    public ProductFieldKey(int productId, int fieldId) {
        this.productId = productId;
        this.fieldId = fieldId;
    }

    public ProductFieldKey()
    {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }
}
