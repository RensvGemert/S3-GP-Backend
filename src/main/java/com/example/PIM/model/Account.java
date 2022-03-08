package com.example.PIM.model;

public class Account {
    public Integer accountId;
    public String accountName;
    public String accountEmail;

    public Account() {
    }

    public Account(Integer accountId, String accountName, String accountEmail) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                '}';
    }
}
