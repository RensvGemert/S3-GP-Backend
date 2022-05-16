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

    public Field(int Id, String Name) {
        id = Id;
        name = Name;
    }

    public Field(String Name) {
        name = Name;
    }

    public Field(){

    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
