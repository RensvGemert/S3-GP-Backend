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
    public int companyid;
    public String companyname;
    public String companydiscription;
    public byte companyrole;
    public LocalDateTime createdat;
    public LocalDateTime updatedat;
    @OneToMany(mappedBy = "company")
    public Set<Product> products = new HashSet<>();
    @OneToMany(mappedBy = "company")
    public Set<User> users = new HashSet<>();



    public Company()
    {

    }

    public Company(int companyid, String companyname, String companydiscription, byte companyrole, LocalDateTime createdat, LocalDateTime updatedat, Set<Product> products, Set<User> users) {
        this.companyid = companyid;
        this.companyname = companyname;
        this.companydiscription = companydiscription;
        this.companyrole = companyrole;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.products = products;
        this.users = users;
    }
    public Company(String companyname, String companydiscription, byte companyrole, LocalDateTime createdat, LocalDateTime updatedat) {

        this.companyname = companyname;
        this.companydiscription = companydiscription;
        this.companyrole = companyrole;
        this.createdat = createdat;
        this.updatedat = updatedat;

    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanydiscription() {
        return companydiscription;
    }

    public void setCompanydiscription(String companydiscription) {
        this.companydiscription = companydiscription;
    }

    public byte getCompanyrole() {
        return companyrole;
    }

    public void setCompanyrole(byte companyrole) {
        this.companyrole = companyrole;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
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
                "companyid=" + companyid +
                ", companyname='" + companyname + '\'' +
                ", companydiscription='" + companydiscription + '\'' +
                ", companyrole=" + companyrole +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", products=" + products +
                ", users=" + users +
                '}';
    }
}
