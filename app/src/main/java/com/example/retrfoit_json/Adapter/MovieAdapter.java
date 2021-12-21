package com.example.retrfoit_json.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrfoit_json.Model.Movie;
import com.example.retrfoit_json.R;
import com.example.retrfoit_json.activity.MainActivity_Detils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int position) {

        myViewHolder.txt_name.setText(movieList.get(position).getNamepd());
        myViewHolder.txt_team.setText(movieList.get(position).getTeam());

        Glide.with(context).load(movieList.get(position).getImagepd()).into(myViewHolder.image);

        myViewHolder.txt_createdby.setText(movieList.get(position).getCreatedby());
        myViewHolder.itemView.setOnClickListener(view -> {

            //Context context = view.getContext();
            Intent intent = new Intent(context, MainActivity_Detils.class);
            intent.putExtra("namepd", movieList.get(position).getNamepd());
            intent.putExtra("imagepd", movieList.get(position).getImagepd());

            context.startActivity(intent);
            //((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txt_name, txt_team, txt_createdby;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_team = itemView.findViewById(R.id.txt_team);
            txt_createdby = itemView.findViewById(R.id.txt_createdby);
        }
    }
}
