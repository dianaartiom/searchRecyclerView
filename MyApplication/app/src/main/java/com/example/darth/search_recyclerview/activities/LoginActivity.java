package com.example.darth.search_recyclerview.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.controllers.SessionManager;
import com.example.darth.search_recyclerview.controllers.UserController;
import com.example.darth.search_recyclerview.model.LoginUserModel;
import com.example.darth.search_recyclerview.model.ResponseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private UserController userController;
    private Button button;
    private Button token_button;
    private EditText emailET;
    private EditText passwordET;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = (EditText) findViewById(R.id.email_et);
        emailET.setText("cvsiserver@gmail.com");
        passwordET = (EditText) findViewById(R.id.password_et);
        passwordET.setText("cvsiserverr");
        button = (Button) findViewById(R.id.log_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });
        token_button = (Button) findViewById(R.id.show_token_button);
        token_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                sessionManager = new SessionManager(getApplicationContext());
                //        sessionManager.checkLogin(getApplicationContext());
//                Log.i(preferences.contains(sessionManager.getToken()).)
                Log.i("TAG", sessionManager.getToken());
                if (preferences.contains(sessionManager.getToken())) {
                    onListItemsButtonClick();
                }
            }
        });


    }

    public void onLoginButtonClick() {
        LoginUserModel userModel = new LoginUserModel();
        userModel.setEmail(emailET.getText().toString());
        userModel.setPassword(passwordET.getText().toString());
        userController = new UserController();
        userController.login(userModel, this.getApplicationContext());
    }

    public void onListItemsButtonClick() {
        Intent getListItemsIntent = new Intent(this, MainActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getListItemsIntent, result);
    }
}
