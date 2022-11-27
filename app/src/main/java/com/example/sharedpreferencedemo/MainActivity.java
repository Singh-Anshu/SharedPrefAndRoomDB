package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String username = sharedPreferences.getString("name", "");
                String password = sharedPreferences.getString("password", "");

                Intent intent ;
                if(username.toString().isEmpty() && password.isEmpty()){
                    intent = new Intent(MainActivity.this, LoginActivity.class);

                }else{
                    intent = new Intent(MainActivity.this, HomeActivity.class);
                }

                startActivity(intent);
            }
        }, 3000);
    }
}