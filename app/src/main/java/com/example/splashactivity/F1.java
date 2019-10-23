package com.example.splashactivity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.splashactivity.Adapter.MovieAdapter;
import com.example.splashactivity.Api.MovieApi;
import com.example.splashactivity.Api.RetrofitClient;
import com.example.splashactivity.model.MovieResponse;
import com.example.splashactivity.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class F1 extends Fragment {
    MovieAdapter movieAdapter;

    public F1() {
        // Required empty public constructor
    }

    private RecyclerView recyclerview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_f1, container, false);
        recyclerview = view.findViewById(R.id.rv);
        setupRecyclerView();
        fetchMovie();
        return view;
    }

    private void setupRecyclerView() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity() ,2);
        recyclerview.setLayoutManager(gridLayoutManager);
        movieAdapter=new MovieAdapter(getActivity());
        recyclerview.setAdapter(movieAdapter);


    }
    private void fetchMovie()
    {
        MovieApi movieApi = RetrofitClient.getInstance().create(MovieApi.class);
        Call<MovieResponse> popular = movieApi.getMovies("popular", "8124ef2e6e88b885330aeeaee94f5d0a");
        popular.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.i( "onResponse: ",response.code()+" "+response.message());
                MovieResponse movieResponse=response.body();
                viewOnRecycler(movieResponse);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.i( "onResponse: ","200");

            }
        });
    }

    private void viewOnRecycler(MovieResponse movieResponse) {
        List<Result> lr=movieResponse.getResults();
        movieAdapter.setData(lr);
        movieAdapter.notifyDataSetChanged();

    }

}
