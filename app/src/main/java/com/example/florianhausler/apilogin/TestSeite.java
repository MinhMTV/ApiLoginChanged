package com.example.florianhausler.apilogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.florianhausler.apilogin.Helper.HelperShared;

public class TestSeite extends AppCompatActivity {

    private static TextView textView, textView1, textView2, textView3, textView4, textView5, textView6;
    private static  final String PREF_UNAME = "username";
    private static  final String PREF_PASSWORD = "password";
    private static  final String PREF_TOKEN = "token";
    private static final String PREF_ORGID = "orgid";

    private static Button btn_logout;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        String displaytoken = HelperShared.load(getApplicationContext(), PREF_TOKEN);
        textView.setText(displaytoken);

        String displayname = HelperShared.load(getApplicationContext(), PREF_UNAME);
        textView1.setText(displayname);

        String displaypw = HelperShared.load(getApplicationContext(), PREF_PASSWORD);
        textView2.setText(displaypw);

        String displayOrg = HelperShared.load(getApplicationContext(), PREF_ORGID);
        textView3.setText(displayOrg);





        btn_logout = (Button) findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Token ist+ " + HelperShared.load(getApplicationContext(),PREF_TOKEN));
                Log.d(TAG,"Username ist+ " +HelperShared.load(getApplicationContext(),PREF_UNAME));
                Log.d(TAG,"Passwort ist+ " +HelperShared.load(getApplicationContext(),PREF_PASSWORD));


                HelperShared.setLoggedIn(getApplicationContext(),false);
                HelperShared.deleteAll(getApplicationContext());

                Log.d(TAG,"Token ist nach dem Löschen + " + HelperShared.load(getApplicationContext(),PREF_TOKEN));
                Log.d(TAG,"Username ist nach dem Löschen + " +HelperShared.load(getApplicationContext(),PREF_UNAME));
                Log.d(TAG,"Passwort ist nach dem Löschen + " +HelperShared.load(getApplicationContext(),PREF_PASSWORD));

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);


            }
        });


    }
}
