package com.example.PIM.Dtos;

import java.time.LocalDateTime;

public class CategoryDto {
    public int id;
    public String name;

    public CategoryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
