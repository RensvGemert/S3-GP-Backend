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



}
