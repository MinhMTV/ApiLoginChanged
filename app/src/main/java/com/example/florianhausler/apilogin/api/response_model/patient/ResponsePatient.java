package com.example.florianhausler.apilogin.api.response_model.patient;

import com.example.florianhausler.apilogin.api.response_model.Response;
import com.example.florianhausler.apilogin.api.response_model.projects.Project;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ResponsePatient extends Response {
    private PatProj [] value;

    public PatProj[] getValue() {
        return value;
    }

    public class PatProj{
        private String project_id;
        private Patient [] patients;

        public String getProject_id() {
            return project_id;
        }

        public Patient[] getPatients() {
            return patients;
        }

        public Patient getPatientWithName(String name){
            for (Patient p : patients) {
                String pName = p.getShort_name();
                if(pName.equals(name)){
                    return p;
                }else{
                    throw new NoSuchElementException();
                }
            }

            return null;
        }

        @Override
        public String toString() {
            return "PatProj{" +
                    "project_id='" + project_id + '\'' +
                    ", patients=" + Arrays.toString(patients) +
                    '}';
        }
    }
}
