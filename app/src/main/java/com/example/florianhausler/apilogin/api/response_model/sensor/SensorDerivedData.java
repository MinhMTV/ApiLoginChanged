package com.example.florianhausler.apilogin.api.response_model.sensor;

import com.example.florianhausler.apilogin.api.response_model.Response;

public class SensorDerivedData extends Response {
    private String status_code;
    private String status_msg;
    private SensorData value;

    public SensorDerivedData(String status_code, String status_msg) {
        super();
        this.value = value;
    }
    public String toString(){
        return "Sensor: "+value.getSensorId();
    }

    public SensorData getValue() {
        return value;
    }

    public class SensorData{
        private String sensorId;
        private String startTime;
        private String endTime;
        private String window;

        public SensorData(String sensorId, String startTime, String endTime, String window, Stream stream) {
            this.sensorId = sensorId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.window = window;
            this.stream = stream;
        }

        public String getSensorId() {
            return sensorId;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public String getWindow() {
            return window;
        }

        public Stream getStream() {
            return stream;
        }

        private Stream stream;

    }
}
