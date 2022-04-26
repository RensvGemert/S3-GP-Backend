package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String description;
    public boolean role;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    @OneToMany(mappedBy = "company")
    public Set<Product> products = new HashSet<>();
    @OneToMany(mappedBy = "companyId")
    public Set<User> users = new HashSet<>();



    public Company()
    {

    }

    public Company(int companyId, String companyName, String companyDescription, byte companyRole, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Product> products, Set<User> users) {
        this.id = companyId;
        this.name = companyName;
        this.description = companyDescription;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
        this.users = users;
    }

    public Company(String name, String description, byte companyRole, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Product> products, Set<User> users) {

        this.name = name;
        this.description = description;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
        this.users = users;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", products=" + products +
                ", users=" + users +
                '}';
    }
}
