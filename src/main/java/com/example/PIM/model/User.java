package com.example.PIM.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    public String name;
    @Column(unique=true)
    public String email;
    public String password;
    public boolean role;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(mappedBy = "user")
    public Set<Message> Recievedmessages = new HashSet<>();




    public User() {
    }

    public User(int userId, String name, String email, String password, boolean role, Company company, Set<Message> recievedmessages) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.company = company;
        Recievedmessages = recievedmessages;
    }

    public User(String name, String email, String password, boolean role, Company company, Set<Message> recievedmessages) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.company = company;
        Recievedmessages = recievedmessages;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Message> getRecievedmessages() {
        return Recievedmessages;
    }

    public void setRecievedmessages(Set<Message> recievedmessages) {
        Recievedmessages = recievedmessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", company=" + company +
                ", Recievedmessages=" + Recievedmessages +
                '}';
    }
}
