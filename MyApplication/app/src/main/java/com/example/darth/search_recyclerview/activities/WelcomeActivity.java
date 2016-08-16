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

public class WelcomeActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonListItems;
    SessionManager sessionManager;
    UserController userController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        buttonListItems = (Button) findViewById(R.id.list_items_button);
        buttonLogin = (Button) findViewById(R.id.login_button);

        buttonListItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListItemsButtonClick(v);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });
    }

    public void onListItemsButtonClick(View view) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sessionManager = new SessionManager(getApplicationContext());
        //        sessionManager.checkLogin(getApplicationContext());
//                Log.i(preferences.contains(sessionManager.getToken()).)
        if (sessionManager.getToken() != null) {
            Log.i("TAG", sessionManager.getToken());
            Intent getListItemsIntent = new Intent(this, LoginActivity.class);
            final int result = 1;
            getListItemsIntent.putExtra("callingActivity", "WelcomeActivity");
            startActivityForResult(getListItemsIntent, result);

        } else {
            Log.w("TAG", "fignea cacaeta");


            Intent getListItemsIntent = new Intent(this, MainActivity.class);
            final int result = 1;
            getListItemsIntent.putExtra("callingActivity", "WelcomeActivity");
            startActivityForResult(getListItemsIntent, result);
        }
    }

    public void onLoginButtonClick() {
        Intent getListItemsIntent = new Intent(this, LoginActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "WelcomeActivity");
        startActivityForResult(getListItemsIntent, result);
    }
}
