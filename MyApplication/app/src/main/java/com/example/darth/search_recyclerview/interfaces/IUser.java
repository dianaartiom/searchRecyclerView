package com.example.darth.search_recyclerview.interfaces;

import com.example.darth.search_recyclerview.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by diana on 8/15/16.
 */
public interface IUser {

    @POST("login")
    Call<User> log(@Body User user);
}
