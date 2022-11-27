package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    EditText usernameEt, passwordEt, phoneNo;

    ArrayList<Users> usersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.loginbtn);
        usernameEt = findViewById(R.id.usernameEt);
        passwordEt = findViewById(R.id.passwordEt);
        phoneNo = findViewById(R.id.phoneNoEt);

        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                String phoneno = String.valueOf(phoneNo.getText().toString());

                if(!username.isEmpty() && !password.isEmpty()){

                    //Saving in SharedPreference
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("name", username);
                    editor.putString("password", password);
                    editor.apply();

                    //Saving in Room Database
                    dataBaseHelper.usersDAO().insert(new Users(username, password, phoneno));
                    usersArrayList = (ArrayList<Users>) dataBaseHelper.usersDAO().getAllUsers();

                    for(int i=0; i< usersArrayList.size(); i++){
                        Log.i("Data","Username: " + usersArrayList.get(i).getUsername() + " Password: " + usersArrayList.get(i).getPassword()+ " PhoneNo: "+ usersArrayList.get(i).getPhoneNo());
                    }

                    // Calling Activity
                    Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(iHome);

                }else{
                    Toast.makeText(LoginActivity.this, "Please Enter Both Value", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}