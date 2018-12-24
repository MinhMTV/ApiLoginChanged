package com.example.florianhausler.apilogin.api.response_model.projects;

import android.util.Log;

import com.example.florianhausler.apilogin.api.response_model.Response;
import com.example.florianhausler.apilogin.api.response_model.org.OrgData;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ResponseProject extends Response {

    private Proj[] value;


    @Override
    public String toString() {
        return "ResponseProject{" +
                "value=" + Arrays.toString(value) +
                '}';
    }

    public Proj[] getValue() {
        return value;
    }



    public class Proj{
        private OrgData organization;
        private Project[] projects;

        public OrgData getOrg() {
            return organization;
        }

        public Project[] getProjects() {
            return projects;
        }

        public Project getProjectWithName(String name){
            for(int i=0;i<projects.length;i++){
                Log.d("MainActivity",projects[i].toString());
                if (projects[i].getShort_name().equals(name)) {
                    return projects[i];
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "Proj{" +
                    "org=" + organization +
                    ", projects=" + Arrays.toString(projects) +
                    '}';
        }
    }
}
