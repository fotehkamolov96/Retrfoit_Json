package com.example.retrfoit_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.retrfoit_json.Adapter.MovieAdapter;
import com.example.retrfoit_json.Common.Common;
import com.example.retrfoit_json.Interface.RetrofitService;
import com.example.retrfoit_json.Model.Movie;
import com.example.retrfoit_json.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerMovie;
    RetrofitService mService;
    RecyclerView.LayoutManager layoutManager;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mService = Common.getMovies2();

        recyclerMovie = findViewById(R.id.recyclerMovie2);
        recyclerMovie.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerMovie.setLayoutManager(layoutManager);

        getAllMovieList();


    }

    private void getAllMovieList() {
        mService.getAllMovies2().enqueue(new Callback<List<Movie>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                adapter = new MovieAdapter(getBaseContext(), response.body());
                adapter.notifyDataSetChanged();
                recyclerMovie.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
}