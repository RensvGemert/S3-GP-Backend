package com.example.PIM.Dtos;

public class ProductFieldDto {
    public String name;
    public String value;
    public int fieldId;

    public ProductFieldDto(String name, String value, int id) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
