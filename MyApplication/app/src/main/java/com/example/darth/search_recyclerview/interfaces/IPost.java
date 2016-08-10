package com.example.darth.search_recyclerview.interfaces;

import com.example.darth.search_recyclerview.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by diana on 8/9/16.
 */
public interface IPost {

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
