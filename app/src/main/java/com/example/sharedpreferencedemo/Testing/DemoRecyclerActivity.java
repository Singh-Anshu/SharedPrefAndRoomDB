package com.example.sharedpreferencedemo.Testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sharedpreferencedemo.R;

import java.util.ArrayList;

public class DemoRecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DemoAdapter demoAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycler);

        recyclerView = findViewById(R.id.recyclerview);

        arrayList.add("Anshu");
        arrayList.add("Raj");
        arrayList.add("Praful");
        arrayList.add("Sachin");
        arrayList.add("Bhavin");
        arrayList.add("Rishab");
        arrayList.add("Mayur");
        arrayList.add("Girish");
        arrayList.add("Amit");
        arrayList.add("Sharique");
        arrayList.add("Singh");
        arrayList.add("Shidesh");
        arrayList.add("Prasant");
        arrayList.add("Prathamesh");
        arrayList.add("Vivek");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        demoAdapter = new DemoAdapter(DemoRecyclerActivity.this,arrayList);
        recyclerView.setAdapter(demoAdapter);
    }
}