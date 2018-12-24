package com.example.florianhausler.apilogin.api.response_model.org;

import android.util.Log;

import com.example.florianhausler.apilogin.api.response_model.Response;

import java.util.Arrays;

public class Organization extends Response {

    private Org value;


    public Organization (Org value) {
        super();
        this.value = value;
    }

    public Org getValue() {
        return value;
    }

    public class Org{
        private OrgData[] organizations;

        public OrgData[] getOrganizations() {
            return organizations;
        }

        @Override
        public String toString() {
            return "Org{" +
                    "datas=" + Arrays.toString(organizations) +
                    '}';
        }
    }
}
