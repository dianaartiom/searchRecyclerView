package com.example.darth.search_recyclerview.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.darth.search_recyclerview.activities.LoginActivity;
import com.example.darth.search_recyclerview.model.ResponseUser;
import com.example.darth.search_recyclerview.model.User;
import com.example.darth.search_recyclerview.utils.JsonMarshaller;

/**
 * Created by diana on 8/15/16.
 */
public class SessionManager {

    private final static String PREFS_NAME = "myPrefs";
    private final static String TAG = "SessionManager";
    public final static String TOKEN = "TOKEN";
    public final static String CACHE = "CACHE";
    private final static String USER = "USER";
    Context context;
    SharedPreferences sharedPreferences;


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(CACHE, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        sharedPreferences.edit().putString(TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public void saveUser(User responseUser) {
        try {
            sharedPreferences.edit().putString(USER, JsonMarshaller.toJson(responseUser)).apply();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public User getUser() {
        String jsonData = sharedPreferences.getString(USER, null);
        if (jsonData != null) {
            try {
                return JsonMarshaller.fromJson(User.class, jsonData);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    public void logout() {
        sharedPreferences.edit().putString(TOKEN, null).apply();
    }

//    public void checkLogin(Context _context){
//        // Check login status
//        if(this.sharedPreferences.getString(TOKEN)){
//            // user is not logged in redirect him to Login Activity
//            Intent i = new Intent(_context, LoginActivity.class);
//            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            // Add new Flag to start new Activity
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            // Staring Login Activity
//            _context.startActivity(i);
//        }
//
//    }
}
