package com.example.florianhausler.apilogin.api.request_models;

public class Login {
    private String user_id;
    private String password;

    public Login(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }
}
