package com.example.florianhausler.apilogin.api.response_model.patient;

public class Patient {
    private String id;
    private String short_name;
    private String description;
    private String deleted;
    private String timezone;

    public String getId() {
        return id;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeleted() {
        return deleted;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", short_name='" + short_name + '\'' +
                ", description='" + description + '\'' +
                ", deleted='" + deleted + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
