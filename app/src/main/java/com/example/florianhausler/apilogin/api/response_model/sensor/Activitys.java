package com.example.florianhausler.apilogin.api.response_model.sensor;

import com.google.gson.annotations.SerializedName;

public class Activitys {
    @SerializedName("activity/resting/time")
    private float restingTime;
    @SerializedName("activity/stansding/time")
    private float standingTime;
    @SerializedName("activity/walking/time")
    private float walkingTime;
    @SerializedName("activity/cycling/time")
    private float cyclingTime;
    @SerializedName("activity/exercise/time")
    private float exerciseTime;
    @SerializedName("activity/other/time")
    private float otherTime;
    @SerializedName("general/nodata/time")
    private float generalNodataTime;
    @SerializedName("activity/step/count")
    private float activityStepsCount;


    public float getActivityrestingtime() {
        return restingTime;
    }

    public float getActivityStandingTime() {
        return standingTime;
    }

    public float getActivityWalkingTime() {
        return walkingTime;
    }

    public float getActivityCyclingTime() {
        return cyclingTime;
    }

    public float getActivityExerciseTime() {
        return exerciseTime;
    }

    public float getActivityOtherTime() {
        return otherTime;
    }

    public float getGeneralNodataTime() {
        return generalNodataTime;
    }

    public float getActivityStepsCount() {
        return activityStepsCount;
    }

    @Override
    public String toString() {
        return "Activitys{" +
                "activityrestingtime=" + restingTime +
                ", activityStandingTime=" + standingTime +
                ", activityWalkingTime=" + walkingTime +
                ", activityCyclingTime=" + cyclingTime +
                ", activityExerciseTime=" + exerciseTime +
                ", activityOtherTime=" + otherTime +
                ", generalNodataTime=" + generalNodataTime +
                ", activityStepsCount=" + activityStepsCount +
                '}';
    }
}
