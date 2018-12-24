package com.example.florianhausler.apilogin.api.response_model.sensor;

public class Stream {
    private String alf_profile;
    private Datas[] streams;

    public Stream(String alf_profile, Datas[] streams) {
        this.alf_profile = alf_profile;
        this.streams = streams;
    }

    public String getAlf_profile() {

        return alf_profile;
    }

    public void setAlf_profile(String alf_profile) {
        this.alf_profile = alf_profile;
    }

    public Datas[] getStreams() {
        return streams;
    }

    public void setStreams(Datas[] streams) {
        this.streams = streams;
    }
    class Datas{
        private int ts;
        private Activitys summary;



    }
}
