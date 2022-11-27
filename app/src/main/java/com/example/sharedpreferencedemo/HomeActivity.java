package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button logoutbtn;
    TextView usernameTv, passwordTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logoutbtn = findViewById(R.id.logoutbtn);
        usernameTv = findViewById(R.id.useridTv);
        passwordTV = findViewById(R.id.userpswdTv);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String username = sharedPreferences.getString("name", "");
        String password = sharedPreferences.getString("password", "");

        usernameTv.setText(username);
        passwordTV.setText(password);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", "");
                editor.putString("password", "");
                editor.apply();

                //HomeActivity.this.finish();
                //System.exit(0);

            }
        });


    }
}