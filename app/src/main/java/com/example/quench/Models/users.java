package com.example.quench.Models;

public class users {
    String eMail, password;
    public users(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }
//public users(){}
//    public users(String eMail, String password) {
//        this.eMail = eMail;
//        this.password = password;
//    }
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
