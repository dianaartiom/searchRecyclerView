package com.example.darth.search_recyclerview.controllers;

import android.content.Context;

import com.example.darth.search_recyclerview.interfaces.IUser;
import com.example.darth.search_recyclerview.model.LoginUserModel;
import com.example.darth.search_recyclerview.model.ResponseUser;
import com.example.darth.search_recyclerview.model.User;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by diana on 8/15/16.
 */
public class UserController {

    private Retrofit retrofit;
    private IUser iUser;
    private OkHttpClient okHttpClient;
    private String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private ResponseUser responseUser;

    public UserController() {
        this.okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.iUser = retrofit.create(IUser.class);
    }

    public void login(LoginUserModel user, final Context context){
        iUser.log(user).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                SessionManager sessionManager = new SessionManager(context);
                if (!(response.body() == null)) {
                    sessionManager.saveToken(response.body().getToken());
                    sessionManager.saveUser(response.body().getUser());
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {

            }
        });
    }

    public ResponseUser getResponseUser() {
        return this.responseUser;
    }
}
