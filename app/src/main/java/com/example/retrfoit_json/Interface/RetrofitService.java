package com.example.retrfoit_json.Interface;


import com.example.retrfoit_json.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("testpars.json")
    Call<List<Movie>> getAllMovies();

    @GET("upf.json")
    Call<List<Movie>> getAllMovies2();
}
