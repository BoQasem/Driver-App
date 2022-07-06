package com.example.driverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.example.driverapp.ui.login.LoginActivity;

import com.example.driverapp.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    public void run_activity(){
        if(LoginActivity.checkbox.equals("false")){
            Toast.makeText(this,"Please Login",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }else if(LoginActivity.checkbox.equals("true") ){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();  // hide bar
        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        LoginActivity.checkbox = preferences.getString("remeber","false");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                run_activity();
            }
        };
        handler.postDelayed(runnable,2*1000);
    }
}