package com.example.PIM.model;

import javax.persistence.*;

@Entity
@Table(name = "field")
public class Field {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    @Column(unique=true)
    public String Name;

    public Field(int id, String name) {
        Id = id;
        Name = name;
    }

    public Field(String name) {
        Name = name;
    }

    public Field(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Field{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
