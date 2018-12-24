package com.example.florianhausler.apilogin;


import com.example.florianhausler.apilogin.api.response_model.Response;

public class User extends Response {
    private Token value;

    public User(Token value) {
        super();
        this.value = value;
    }


    public Token getValue() {
        return value;
    }

    public void setValue(Token value) {
        this.value = value;
    }

    class Token{
        private String auth_token;

        @Override
        public String toString() {
            return auth_token;
        }
    }


}
