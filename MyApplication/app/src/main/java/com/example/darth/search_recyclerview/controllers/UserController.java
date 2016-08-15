package com.example.darth.search_recyclerview.controllers;

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

/**
 * Created by diana on 8/15/16.
 */
public class UserController {

    private Retrofit retrofit;
    private IUser iUser;
    private OkHttpClient okHttpClient;
    private String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";

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

    public void login(){
        iUser.log(new User()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
