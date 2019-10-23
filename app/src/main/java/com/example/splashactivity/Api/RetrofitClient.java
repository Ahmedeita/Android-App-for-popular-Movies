package com.example.splashactivity.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit getInstance()
    {
        Retrofit.Builder retrofitBuilder=new Retrofit.Builder();
        Retrofit.Builder builder = retrofitBuilder.baseUrl("https://api.themoviedb.org").addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
}
