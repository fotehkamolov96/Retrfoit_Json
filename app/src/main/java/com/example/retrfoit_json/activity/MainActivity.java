package com.example.retrfoit_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrfoit_json.api.MonthResponse;
import com.example.retrfoit_json.R;
import com.example.retrfoit_json.RetrofitClient;
import com.example.retrfoit_json.adapter.MonthAdapter;
import com.example.retrfoit_json.api.ApiMonth;
import com.example.retrfoit_json.model.MonthModel;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MonthModel> monthModels;
    private ProgressDialog progressDialog;
    private MonthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait.....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        getAllData();


    }


    private void getAllData() {
        ApiMonth apiMonth = RetrofitClient.getRetrofit().create(ApiMonth.class);
        Call<MonthResponse> call = apiMonth.getAllResponse();
        call.enqueue(new Callback<MonthResponse>() {
            @Override
            public void onResponse(Call<MonthResponse> call, Response<MonthResponse> response) {

                if (response.isSuccessful()) {
                    MonthResponse monthResponse = response.body();
                    monthModels = new ArrayList<>(Arrays.asList(monthResponse.getMonths()));
                    adapter = new MonthAdapter(MainActivity.this, monthModels);
                    recyclerView.setAdapter(adapter);
                    progressDialog.show();

                }
            }

            @Override
            public void onFailure(Call<MonthResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Нет соединения с интернетом!", Toast.LENGTH_LONG).show();
            }
        });
    }


}