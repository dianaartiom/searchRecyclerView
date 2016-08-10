package com.example.darth.search_recyclerview.controllers;

import com.example.darth.search_recyclerview.interfaces.IPost;
import com.example.darth.search_recyclerview.model.Post;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 8/9/16.
 */
public class PostsController {

    public static final String SERVER_URL = "https://jsonplaceholder.typicode.com/";

    public Retrofit initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public void getPosts() {
        Retrofit retrofit = initRetrofit();
        IPost iPost = retrofit.create( IPost.class);
        Call<List<Post>> postList = iPost.getAllPosts();
        enqueuePostList(postList);
    }

    public void enqueuePostList(Call<List<Post>> postList) {
        postList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
