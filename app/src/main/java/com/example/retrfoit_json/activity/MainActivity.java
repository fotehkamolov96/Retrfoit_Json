package com.example.retrfoit_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrfoit_json.adapter.SearchResponse;
import com.example.retrfoit_json.R;
import com.example.retrfoit_json.adapter.RetrofitClient;
import com.example.retrfoit_json.adapter.SearchAdapter;
import com.example.retrfoit_json.adapter.ApiInterface;
import com.example.retrfoit_json.adapter.SearchModel;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ArrayList<SearchModel> searchModels;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Пожалуйста подождите.....");
        progressDialog.setCancelable(false);
        progressDialog.show();*/

        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getAllData();
    }


    private void getAllData() {
        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<SearchResponse> call = apiInterface.getAllResponse();

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    SearchResponse monthResponse = response.body();
                    assert monthResponse != null;
                    searchModels = new ArrayList<>(Arrays.asList(monthResponse.getSearch()));
                    adapter = new SearchAdapter(MainActivity.this, searchModels);
                    recyclerView.setAdapter(adapter);
                    //progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                progressDialog.show();
                //Toast.makeText(MainActivity.this, "Нет соединения с интернетом!", Toast.LENGTH_LONG).show();
            }
        });
    }


}