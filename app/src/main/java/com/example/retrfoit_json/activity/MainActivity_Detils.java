package com.example.retrfoit_json.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrfoit_json.R;

public class MainActivity_Detils extends AppCompatActivity {
    TextView nameP;
    ImageView imageP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_detils);
        nameP = findViewById(R.id.textView);
        imageP = findViewById(R.id.imageView);

        Intent intent = getIntent();

        String name_pd = intent.getStringExtra("namepd");
        String image_pd = intent.getStringExtra("imagepd");

        nameP.setText(name_pd);
        Glide.with(this)
                .load(image_pd)
                .into(imageP);

    }
}