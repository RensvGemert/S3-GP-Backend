package com.example.PIM.model;

import javax.persistence.*;

@Entity
@Table(name = "field")
public class Field {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(unique=true)
    public String name;

    public Field(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Field(String name) {
        this.name = name;
    }

    public Field() {
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

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
