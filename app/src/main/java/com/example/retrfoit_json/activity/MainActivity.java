package com.example.retrfoit_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.retrfoit_json.modelttttt.Adapter_upr;
import com.example.retrfoit_json.modelttttt.UdpModel;
import com.example.retrfoit_json.R;
import com.example.retrfoit_json.modelttttt.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridLayoutManager layoutManager;
    ProgressBar progress;

    private RequestQueue requestQueue;
    RecyclerView rv_upr;
    List<UdpModel> udpModels;
    Adapter_upr adpUpr;
    private int page = 0;

    private static final String Upf = "https://raw.githubusercontent.com/fotehkamolov96/test/main/dn/testpars.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        progress = (ProgressBar) findViewById(R.id.doc_progress_id);
        rv_upr = findViewById(R.id.recyclerView);
        rv_upr.setHasFixedSize(true);

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        rv_upr.setLayoutManager(layoutManager);




        udpModels = new ArrayList<>();
        getAllData();*/


        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });


    }





    private void getAllData() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Upf, null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject updobject = response.getJSONObject(i);
                            UdpModel upd = new UdpModel();
                            upd.setNamepd(updobject.getString("namepd").toString());
                            upd.setImagepd(updobject.getString("imagepd"));

                            udpModels.add(upd);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    rv_upr.setLayoutManager(new LinearLayoutManager(this));
                    adpUpr = new Adapter_upr(this, udpModels);
                    rv_upr.setHasFixedSize(true);
                    rv_upr.setAdapter(adpUpr);

                },
                error -> {
                    Log.d("tag", "onErrorResponse: " + error.getMessage());
                });
        requestQueue.add(jsonArrayRequest);
        //queue.add(jsonArrayRequest);
    }


}