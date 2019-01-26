package com.example.sheetalkumar.swasthya.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

       // @GET("posts")
       @GET("bins/8uimo")
        Call<List<Post>> getPosts();
}
