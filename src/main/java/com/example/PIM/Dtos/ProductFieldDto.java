package com.example.PIM.Dtos;

public class ProductFieldDto {
    public String value;
    public int fieldId;

    public ProductFieldDto(String value, int id) {
        this.value = value;
        this.fieldId = id;
    }

    public ProductFieldDto()
    {

    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
