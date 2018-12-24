package com.example.florianhausler.apilogin.api.response_model.progress;

import com.example.florianhausler.apilogin.api.response_model.Response;

import java.util.Arrays;

public class ResponseProgress extends Response {
    private Datas value;

    @Override
    public String toString() {
        return "ResponseProgress{" +
                "value=" + value +
                '}';
    }

    public class Datas {
        private ActivityData [] data;

        @Override
        public String toString() {
            return "Datas{" +
                    "data=" + Arrays.toString(data) +
                    '}';
        }
    }

}
