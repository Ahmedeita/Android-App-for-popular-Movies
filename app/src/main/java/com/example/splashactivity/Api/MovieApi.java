package com.example.splashactivity.Api;

import com.example.splashactivity.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("/3/movie/{sort}")
    Call<MovieResponse> getMovies(@Path("sort") String sort, @Query("api_key") String key);

}
