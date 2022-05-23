package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    public int role;
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    public Set<Message> Recievedmessages = new HashSet<>();

    /*@ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id")*/
    public int companyId;

    public User(int id, int role) {
        this.id = id;
        this.role = role;
    }

    public User() {
    }

    public User(int id, String name, String email, String password, int role, int companyId, Set<Message> recievedmessages, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.companyId = companyId;
        Recievedmessages = recievedmessages;
        this.createdAt = createdAt;
    }

    public User(String name, String email, String password, int role, int companyId, Set<Message> recievedmessages, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.companyId = companyId;
        Recievedmessages = recievedmessages;
        this.createdAt = createdAt;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Message> getRecievedmessages() {
        return Recievedmessages;
    }

    public void setRecievedmessages(Set<Message> recievedmessages) {
        Recievedmessages = recievedmessages;
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", companyId=" + companyId +
                ", Recievedmessages=" + Recievedmessages +
                ", created_At=" + createdAt +
                '}';
    }
}
