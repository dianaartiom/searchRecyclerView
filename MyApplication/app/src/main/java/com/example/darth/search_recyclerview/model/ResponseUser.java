package com.example.darth.search_recyclerview.model;

/**
 * Created by diana on 8/15/16.
 */
public class ResponseUser {

    private String token;
    private User userDto;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return userDto;
    }

    public void setUser(User user) {
        this.userDto = user;
    }
}
