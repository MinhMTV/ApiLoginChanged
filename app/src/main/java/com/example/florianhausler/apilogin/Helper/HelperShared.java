package com.example.florianhausler.apilogin.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class HelperShared {

    private static final String SHARED_PREFERENCE_FILE = "data";
    private static final String DEFAULT_VALUE = "NULL";
    public static final String LOGGED_IN_PREF = "logged_in_status";
    private static SharedPreferences sharedPreferences;

    public static void save(Context context, String key, String value) {

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String load(Context context, String key) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, DEFAULT_VALUE);
    }

    public static void setLoggedIn(Context context, boolean loggedIn) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }


    public static boolean getLoggedStatus(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGGED_IN_PREF,false);


    }


    public static void saveAll(Context context, Map<String, String> sharedPreferenceDataList) {

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (Map.Entry<String, String> entry : sharedPreferenceDataList.entrySet()) {
            editor.putString(entry.getKey(), entry.getValue());
        }

        editor.apply();
    }

    public static void deleteAll(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static Map<String, String> getAll(Context context) {

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE);
        Map<String, String> allSharedPreferences = new HashMap<>();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            allSharedPreferences.put(entry.getKey(), entry.getValue().toString());
        }

        return allSharedPreferences;
    }

}

