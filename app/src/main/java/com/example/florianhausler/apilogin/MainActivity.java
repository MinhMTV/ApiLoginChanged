package com.example.florianhausler.apilogin;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.florianhausler.apilogin.Helper.HelperShared;
import com.example.florianhausler.apilogin.api.UserClient;
import com.example.florianhausler.apilogin.api.request_models.Login;
import com.example.florianhausler.apilogin.api.response_model.keys.ResponseKeys;
import com.example.florianhausler.apilogin.api.response_model.org.OrgData;
import com.example.florianhausler.apilogin.api.response_model.org.Organization;
import com.example.florianhausler.apilogin.api.response_model.patient.Patient;
import com.example.florianhausler.apilogin.api.response_model.patient.ResponsePatient;
import com.example.florianhausler.apilogin.api.response_model.progress.ResponseProgress;
import com.example.florianhausler.apilogin.api.response_model.projects.Project;
import com.example.florianhausler.apilogin.api.response_model.projects.ResponseProject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText etName;
    private  EditText etpassword;
    private static final String TAG = MainActivity.class.getName();

    private static  final String PREF_UNAME = "username";
    private static  final String PREF_PASSWORD = "password";
    private static  final String PREF_TOKEN = "token";
    private static final String PREF_ORGID = "orgid";
    private static final String BASE_URL = "beta.sens.dk";
    private String UnameValue;
    private String PasswordValue;

    UserClient userClient;

    private String token;
    private String orgId;
    private String projId;
    private String patId;
    private String proKey;
    private String patKey;
    private String shownDate="2018-10-01";
    private String dayCount="6";

    private static final String PROJECT_NAME = "sens-demo";
    private static final String PATIENT_NAME = "SENS Demo 2018-09";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(getCacheDir(), cacheSize);

        OkHttpClient.Builder okHttpclient = new OkHttpClient.Builder().cache(cache);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpclient.addInterceptor(logging);

        HttpUrl baseUrl = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_URL)
                .encodedPath("/api/1.0/")
                .build();

         Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                 .client(okHttpclient.build());


        Retrofit retrofit = builder.build();
        userClient = retrofit.create(UserClient.class);


        // Check if UserResponse is Already Logged In
        if(HelperShared.getLoggedStatus(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), TestSeite.class);
            startActivity(intent);
        }

        etName = (EditText) findViewById(R.id.ed_user);
        etpassword = (EditText) findViewById(R.id.ed_pw);
        btn_login = (Button)findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnameValue = etName.getText().toString();
                PasswordValue  = etpassword.getText().toString();
                login();
            }
        });
    }

    private void login(){

        Login login = new Login(UnameValue,PasswordValue);

        Log.d(TAG,"in Response");
        Call<User> call = userClient.login(login);
        Log.d(TAG,call.request().url().toString());

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this,response.body().getStatus_msg(),Toast.LENGTH_LONG).show();
                    token = response.body().getValue().toString();


                    //speichert Values auf dem Geraet mit dem
                    HelperShared.save(getApplicationContext(),PREF_TOKEN, token);
                    HelperShared.save(getApplicationContext(),PREF_UNAME, UnameValue);
                    HelperShared.save(getApplicationContext(),PREF_PASSWORD, PasswordValue);
                    HelperShared.setLoggedIn(getApplicationContext(),true);


                    Log.d(TAG,token);
                    getOrgData();

                    Intent intent = new Intent(MainActivity.this,TestSeite.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,"Email oder Passwort sind falsch",Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Token ist not there");

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG,"Fehler onFailure");


            }
        });
    }
    private void getOrgData() {
       // Call<SensorDerivedData> call = userClient.getSensorDerivedData(token, ORG_ID, PROJ_ID, SENS_ID, WINDOW, ALG_PROF, PAT_PROF, TIME);
        HelperShared.load(MainActivity.this, token);
        Call<Organization> call = userClient.getOrganization(token);
        call.enqueue(new Callback<Organization>() {
            @Override
            public void onResponse(Call<Organization> call, Response<Organization> response) {
                Log.d(TAG,"Erfolgreich");
                OrgData [] tempOrg = response.body().getValue().getOrganizations();
                orgId = tempOrg[0].getId();
                HelperShared.save(getApplicationContext(),PREF_ORGID, orgId);
                Log.d(TAG,"OrgId: "+orgId);
                getProjectData();

            }

            @Override
            public void onFailure(Call<Organization> call, Throwable t) {
                Log.d(TAG,"failure");

            }
        });


    }
    private void getProjectData(){
        Call<ResponseProject> call = userClient.getProject(token,orgId);

        call.enqueue(new Callback<ResponseProject>() {
            @Override
            public void onResponse(Call<ResponseProject> call, Response<ResponseProject> response) {

                ResponseProject.Proj orgMain = response.body().getValue()[0];

                Log.d(TAG,"orgMain" + orgMain);

               Project[] projectList= orgMain.getProjects();

               for (int i = 0 ; i < projectList.length ; i++)
                {
                    String projectName = projectList[i].getShort_name();
                    Log.d(TAG,"Name des Projects " + i + " " + projectName);

                    //  Log.d(TAG,orgMain.toString());
                    // Suchen nach einem Projekt und Speichern
                    Project proj = orgMain.getProjectWithName(projectName);

                    // Log.d(TAG,"Test Ausgabe Projecte:"+proj.toString());
                    projId = proj.getId();
                    Log.d(TAG,"ProjectID:"+proj.getId());
                    getPatientData();
                }
            }

            @Override
            public void onFailure(Call<ResponseProject> call, Throwable t) {
                Log.d(TAG,"failure");

            }
        });

    }
    private void getPatientData(){

        Log.d(TAG,"Project ID von " + orgId + " " + projId);
        Call<ResponsePatient>call = userClient.getPatient(token,orgId,projId);

        call.enqueue(new Callback<ResponsePatient>() {
            @Override
            public void onResponse(Call<ResponsePatient> call, Response<ResponsePatient> response) {
                // Eingabe des Patenten Namens
                //Speichern der Patienten ID

                ResponsePatient.PatProj patienten = response.body().getValue()[0];

                Patient[] patientenListe = patienten.getPatients();

                for (int i = 0; i < patientenListe.length; i++) {

                    String patientenName = patientenListe[i].getShort_name();
                    Log.d(TAG,"Name des Patienten " + i + " " + patientenName + " " + projId);

                    Log.d(TAG, "Patienten: " + response.body().getValue()[0].toString());
                    patId = response.body().getValue()[0].getPatientWithName(patientenName).getId();
                    Log.d(TAG, "PatientenID: " + patId + " " + patientenName + " " + projId);
                    getKey();
                }
            }

            @Override
            public void onFailure(Call<ResponsePatient> call, Throwable t) {
                Log.d(TAG,"failure:"+t.toString());

            }
        });
    }
    private void getKey(){
        Call<ResponseKeys> call = userClient.getKeys(token,orgId,projId,patId);

        call.enqueue(new Callback<ResponseKeys>() {
            @Override
            public void onResponse(Call<ResponseKeys> call, Response<ResponseKeys> response) {
                Log.d(TAG,response.body().toString());
                proKey = response.body().getValue().getProject_key();
                patKey = response.body().getValue().getPatient_key();
                getFirstData();

            }

            @Override
            public void onFailure(Call<ResponseKeys> call, Throwable t) {

            }
        });
    }
    private void getFirstData(){
        Call<ResponseProgress> call = userClient.getProgress(proKey,patKey,shownDate,dayCount);

        call.enqueue(new Callback<ResponseProgress>() {
            @Override
            public void onResponse(Call<ResponseProgress> call, Response<ResponseProgress> response) {
               Log.d(TAG,"Progress: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseProgress> call, Throwable t) {
                Log.d(TAG,"Failure: "+t.toString());

            }
        });


    }
}
