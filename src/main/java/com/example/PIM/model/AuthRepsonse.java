package com.example.PIM.model;

public class AuthRepsonse {

    int userid;
    int role;

    public AuthRepsonse(int userid, int role) {
        this.userid = userid;
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
