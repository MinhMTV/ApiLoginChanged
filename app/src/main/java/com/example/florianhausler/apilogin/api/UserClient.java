package com.example.florianhausler.apilogin.api;

import com.example.florianhausler.apilogin.User;
import com.example.florianhausler.apilogin.api.request_models.Login;
import com.example.florianhausler.apilogin.api.response_model.keys.ResponseKeys;
import com.example.florianhausler.apilogin.api.response_model.org.Organization;
import com.example.florianhausler.apilogin.api.response_model.patient.ResponsePatient;
import com.example.florianhausler.apilogin.api.response_model.progress.ResponseProgress;
import com.example.florianhausler.apilogin.api.response_model.projects.ResponseProject;
import com.example.florianhausler.apilogin.api.response_model.sensor.SensorDerivedData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserClient {
    @Headers("accept: application/json")
    @POST("authenticate")
    Call<User> login(@Body Login login);

    @Headers("accept: application/json")
    @GET("sensor/data/derived")
    Call<SensorDerivedData>getSensorDerivedData(@Header("Auth-Token")String authToken,
                                                @Query("org_id") String orgId,
                                                @Query("project_id") String projektId,
                                                @Query("sensor_id") String sensor_id,
                                                @Query("window_type") String window_type,
                                                @Query("alg_profile") String alg_profile,
                                                @Query("patient_profile")String patient_profile,
                                                @Query("start_time")String start_time);
    @Headers("accept: application/json")
    @GET("organizations")
    Call<Organization>getOrganization(@Header("Auth-Token")String authToken);

    @Headers("accept: application/json")
    @GET("projects")
    Call<ResponseProject>getProject(@Header("Auth-Token")String authToken,
                                    @Query("org_id") String orgId);

    @Headers("accept: application/json")
    @GET("patients")
    Call<ResponsePatient>getPatient(@Header("Auth-Token")String authToken,
                                    @Query("org_id") String orgId,
                                    @Query("project_id") String projectId);

    @Headers("accept: application/json")
    @GET("patient/get_keys")
    Call<ResponseKeys>getKeys(@Header("Auth-Token")String authToken,
                              @Query("org_id") String orgId,
                              @Query("project_id") String projectId,
                              @Query("patient_id") String patientId);

    @Headers("accept: application/json")
    @GET("patient_view/progress")
    Call<ResponseProgress>getProgress(@Query("project_key") String projectKey,
                                      @Query("patient_key") String patientKey,
                                      @Query("date") String date,
                                      @Query("day_count") String dayCount);


}