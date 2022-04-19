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
    public String companyName;
    public String companyDescription;
    public byte companyRole;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    @OneToMany(mappedBy = "company")
    public Set<Product> products = new HashSet<>();
    @OneToMany(mappedBy = "company")
    public Set<User> users = new HashSet<>();



    public Company()
    {

    }

    public Company(int companyId, String companyName, String companyDescription, byte companyRole, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Product> products, Set<User> users) {
        this.id = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyRole = companyRole;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
        this.users = users;
    }

    public Company(String companyName, String companyDiscription, byte companyRole, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Product> products, Set<User> users) {

        this.companyName = companyName;
        this.companyDescription = companyDiscription;
        this.companyRole = companyRole;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
        this.users = users;
    }

    public int getCompanyId() {
        return id;
    }

    public void setCompanyId(int companyId) {
        this.id = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDiscription() {
        return companyDescription;
    }

    public void setCompanyDiscription(String companyDiscription) {
        this.companyDescription = companyDescription;
    }

    public byte getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(byte companyRole) {
        this.companyRole = companyRole;
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
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", companyRole=" + companyRole +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", products=" + products +
                ", users=" + users +
                '}';
    }
}
