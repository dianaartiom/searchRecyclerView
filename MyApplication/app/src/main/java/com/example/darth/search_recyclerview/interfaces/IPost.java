package com.example.darth.search_recyclerview.interfaces;

import com.example.darth.search_recyclerview.model.LoginUserModel;
import com.example.darth.search_recyclerview.model.Post;
import com.example.darth.search_recyclerview.model.ResponseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by diana on 8/9/16.
 */
public interface IPost {

    @GET("posts")
    Call<List<Post>> getAllPosts();

    @POST("login")
    Call<ResponseUser> log(@Body LoginUserModel user);
}
