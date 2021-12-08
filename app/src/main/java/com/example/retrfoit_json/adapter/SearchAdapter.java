package com.example.retrfoit_json.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrfoit_json.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder> {

    private final Context context;
    private final ArrayList<SearchModel> searchModelArrayList;

    public SearchAdapter(Context context, ArrayList<SearchModel> monthModelsArrayList) {
        this.context = context;
        this.searchModelArrayList = monthModelsArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_row_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.textname.setText(searchModelArrayList.get(position).getNametitle());
        holder.textdescription.setText(searchModelArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return searchModelArrayList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private final TextView textname;
        private final TextView textdescription;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.textViewName);
            textdescription = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
