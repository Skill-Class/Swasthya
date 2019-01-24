package com.example.sheetalkumar.swasthya.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

        @GET("posts")
        Call<List<Post>> getPosts();
}
