package com.example.florianhausler.apilogin.api.response_model.org;

public class OrgData {
    private String id;
    private String short_name;
    private String full_name;

    public String getId() {
        return id;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getFull_name() {
        return full_name;
    }

    @Override
    public String toString() {
        return "OrgData{" +
                "id='" + id + '\'' +
                ", short_name='" + short_name + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
