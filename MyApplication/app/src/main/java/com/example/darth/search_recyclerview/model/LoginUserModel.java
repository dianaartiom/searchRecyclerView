package com.example.darth.search_recyclerview.model;

/**
 * Created by diana on 8/15/16.
 */
public class LoginUserModel {
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

    private String email;
    private String password;

    public LoginUserModel() {
        this.email = "cvsiserver@gmail.com";
        this.password = "cvsiserver";
    }


}
