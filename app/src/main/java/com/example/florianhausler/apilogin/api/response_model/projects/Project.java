package com.example.florianhausler.apilogin.api.response_model.projects;

public class Project {
    private String id;
    private String short_name;
    private String full_name;
    private String created;
    private String active;
    private String project_class;

    public String getId() {
        return id;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getCreated() {
        return created;
    }

    public String getActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", short_name='" + short_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", created='" + created + '\'' +
                ", active='" + active + '\'' +
                ", project_class='" + project_class + '\'' +
                '}';
    }
}
