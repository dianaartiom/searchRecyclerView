package com.example.darth.search_recyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.controllers.UserController;
import com.example.darth.search_recyclerview.interfaces.IUser;
import com.example.darth.search_recyclerview.model.User;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class LoginActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private UserController userController;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.log_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });
    }

    public void onLoginButtonClick() {
        userController = new UserController();
        userController.login();
    }
}
