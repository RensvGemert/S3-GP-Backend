package com.example.PIM.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userid;
    public String name;
    @Column(unique=true)
    public String email;
    public String password;
    public boolean role;
    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    @OneToMany(mappedBy = "user")
    public Set<Message> messagesrecieved = new HashSet<>();




    public User() {
    }

    public User(int userid, String name, String email, String password, boolean role, Company company, Set<Message> messagesrecieved) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.company = company;
        this.messagesrecieved = messagesrecieved;
    }

    public User(String name, String email, String password, boolean role, Company company, Set<Message> messagesrecieved) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.company = company;
        this.messagesrecieved = messagesrecieved;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public Set<Message> getMessagesrecieved() {
        return messagesrecieved;
    }

    public void setMessagesrecieved(Set<Message> messagesrecieved) {
        this.messagesrecieved = messagesrecieved;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", company=" + company +
                ", messagesrecieved=" + messagesrecieved +
                '}';
    }
}
