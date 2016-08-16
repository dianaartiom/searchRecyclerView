package com.example.darth.search_recyclerview.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.controllers.SessionManager;
import com.example.darth.search_recyclerview.controllers.UserController;
import com.example.darth.search_recyclerview.model.LoginUserModel;

public class SplashWelcomeActivity extends AppCompatActivity {

    SessionManager sessionManager;
    UserController userController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.getToken() != null) {
            getMainActivity();

        } else {
            getLoginActivity();
        }
    }

    public void getMainActivity() {
        Log.i("TAG", sessionManager.getToken());
        Intent getListItemsIntent = new Intent(this, MainActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "SplashWelcomeActivity");
        startActivityForResult(getListItemsIntent, result);
    }

    public void getLoginActivity() {
        Intent getListItemsIntent = new Intent(this, LoginActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "SplashWelcomeActivity");
        startActivityForResult(getListItemsIntent, result);
    }
}
