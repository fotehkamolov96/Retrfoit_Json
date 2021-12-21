package com.example.retrfoit_json.modelttttt;


import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.retrfoit_json.R;

import java.util.List;

public class Adapter_upr extends RecyclerView.Adapter<Adapter_upr.CustomViewHolder> {

    private final List<UdpModel> udp_models;
    private final Context context;

    public Adapter_upr(Context context, List<UdpModel> up_models) {
        this.context = context;
        this.udp_models = up_models;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_view, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.upr_name.setText(udp_models.get(position).getNamepd());
        Glide.with(holder.upr_image.getContext())
                .load(udp_models.get(position).getImagepd())
                .transition(withCrossFade())
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.upr_image);

    }

    @Override
    public int getItemCount() {
        return (udp_models != null ? udp_models.size() : 0);
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView upr_image;
        public TextView upr_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            upr_name = itemView.findViewById(R.id.textViewName);
            upr_image = itemView.findViewById(R.id.imageView);

        }
    }

    public void AddList(List<UdpModel> imagelist)
    {
        for(UdpModel li : imagelist )
        {
            udp_models.add(li);
        }
        notifyDataSetChanged();
    }
}
