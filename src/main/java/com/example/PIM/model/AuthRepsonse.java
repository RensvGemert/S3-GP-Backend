package com.example.PIM.model;

public class AuthRepsonse {

    int userid;
    int role;
    int companyRole;
    int companyId;

    public AuthRepsonse(int userid, int role, int companyRole, int companyId) {
        this.userid = userid;
        this.role = role;
        this.companyRole = companyRole;
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public int getCompanyRole() {
        return role;
    }

    public void setCompanyRole(int role) {
        this.role = role;
    }



}
