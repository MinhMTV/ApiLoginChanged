package com.example.florianhausler.apilogin.api.response_model.progress;

import com.example.florianhausler.apilogin.api.response_model.sensor.Activitys;

public class ActivityData {
    private String start_time;
    private String end_time;
    private Activitys values;

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public Activitys getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "ActivityData{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", values=" + values +
                '}';
    }
}
