package com.example.retrfoit_json.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrfoit_json.R;
import com.example.retrfoit_json.model.MonthModel;

import java.util.ArrayList;
import java.util.List;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<MonthModel> monthModelsArrayList;

    public MonthAdapter(Context context, ArrayList<MonthModel> monthModelsArrayList) {
        this.context = context;
        this.monthModelsArrayList = monthModelsArrayList;
    }

    @NonNull
    @Override
    public MonthAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_row_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textname.setText(monthModelsArrayList.get(position).getNametitle());
        holder.textdescription.setText(monthModelsArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return monthModelsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
       private TextView textname;
       private TextView textdescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.textViewName);
            textdescription = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
