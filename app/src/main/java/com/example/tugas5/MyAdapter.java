package com.example.tugas5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> name_id, country_id, age_id;
    private View view;

    public MyAdapter(Context context, ArrayList<String> name_id, ArrayList<String> country_id, ArrayList<String> age_id) {
        this.context = context;
        this.name_id = name_id;
        this.country_id = country_id;
        this.age_id = age_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(name_id.get(position));
        holder.country_id.setText(country_id.get(position));
        holder.age_id.setText(age_id.get(position));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, country_id, age_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            country_id = itemView.findViewById(R.id.textcountry);
            age_id = itemView.findViewById(R.id.textage);
        }
    }
}