package com.example.sharedpreferencedemo.Testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sharedpreferencedemo.R;

import java.util.ArrayList;

public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();

    public DemoAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DemoViewHolder(LayoutInflater.from(context).inflate(R.layout.list_demo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        holder.textview1.setText(arrayList.get(position));
        holder.textview2.setText(arrayList.get(position));
        holder.textview3.setText(arrayList.get(position));
        holder.textview4.setText(arrayList.get(position));
        holder.textview5.setText(arrayList.get(position));
        holder.textview6.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

class DemoViewHolder extends RecyclerView.ViewHolder{

    TextView textview1, textview2,textview3,textview4,textview5,textview6;

    public DemoViewHolder(@NonNull View itemView) {
        super(itemView);

        textview1 = itemView.findViewById(R.id.textview1);
        textview2 = itemView.findViewById(R.id.textview2);
        textview3 = itemView.findViewById(R.id.textview3);
        textview4 = itemView.findViewById(R.id.textview4);
        textview5 = itemView.findViewById(R.id.textview5);
        textview6 = itemView.findViewById(R.id.textview6);
    }
}