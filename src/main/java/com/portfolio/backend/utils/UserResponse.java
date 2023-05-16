package com.portfolio.backend.utils;

import com.portfolio.backend.models.UserModel;

public class UserResponse {
    private UserModel user;
    private String token;

    public UserResponse(UserModel user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}