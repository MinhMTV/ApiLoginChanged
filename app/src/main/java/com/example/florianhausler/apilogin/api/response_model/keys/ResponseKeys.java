package com.example.florianhausler.apilogin.api.response_model.keys;

import com.example.florianhausler.apilogin.api.response_model.Response;

public class ResponseKeys extends Response {

    private Keys value;

    public Keys getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ResponseKeys{" +
                "value=" + value +
                '}';
    }

    public class Keys{
        private String project_key;
        private String patient_key;

        public String getProject_key() {
            return project_key;
        }

        public String getPatient_key() {
            return patient_key;
        }

        @Override
        public String toString() {
            return "Keys{" +
                    "project_key='" + project_key + '\'' +
                    ", patient_key='" + patient_key + '\'' +
                    '}';
        }
    }
}
