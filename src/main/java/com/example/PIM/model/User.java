package com.example.PIM.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    @Column(unique=true)
    public String email;
    public String password;
    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    public User() {
    }

    public User(int id, String name, String email, String password, Company company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = company;
    }
    public User(String name, String email, String password, Company company) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = company;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", company=" + company +
                '}';
    }
}
