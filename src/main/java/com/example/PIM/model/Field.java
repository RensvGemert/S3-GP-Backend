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

    public Field(int id, String nname) {
        id = id;
        name = name;
    }

    public Field(String nname) {
        name = name;
    }

    public Field(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nname) {
        name = nname;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
