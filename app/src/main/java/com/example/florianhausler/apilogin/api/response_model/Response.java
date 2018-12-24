package com.example.florianhausler.apilogin.api.response_model;

public class Response {

    private String status_code;
    private String status_msg;


    public String getStatus_code() {
        return status_code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status_code='" + status_code + '\'' +
                ", status_msg='" + status_msg + '\'' +
                '}';
    }

    public String getStatus_msg() {
        return status_msg;
    }
}
