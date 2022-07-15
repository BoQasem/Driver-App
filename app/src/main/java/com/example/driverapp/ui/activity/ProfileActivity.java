package com.example.driverapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.driverapp.R;
import com.example.driverapp.databinding.ActivityProfileBinding;
import com.example.driverapp.ui.chat.SendMessage;
import com.example.driverapp.ui.fragment.ProfileFragment;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    Button chatParent;
    TextView fullNameT;
    TextView ageT;
    TextView ageStudent;
    LinearLayout contentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_bar)));

        fullNameT = findViewById(R.id.fullName_titile);
        ageT = findViewById(R.id.age_title);
        contentName = findViewById(R.id.contentName);
        ageStudent = findViewById(R.id.age_studnet);
        chatParent = findViewById(R.id.chat_parent);
        chatParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatParent.setVisibility(View.GONE);
                fullNameT.setVisibility(View.GONE);
                ageT.setVisibility(View.GONE);
                contentName.setVisibility(View.GONE);
                ageStudent.setVisibility(View.GONE);
                getSupportActionBar().setTitle("Send message to parent");
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.profile_activity,new SendMessage()).commit();
            }
        });
        Intent intent = this.getIntent();
        if(intent != null){
            String firstName = intent.getStringExtra("first_name");
            String lastName = intent.getStringExtra("last_name");
            String surName = intent.getStringExtra("sur_name");
            String age = intent.getStringExtra("age");

            binding.firstName.setText(firstName);
            binding.lastName.setText(lastName);
            binding.surName.setText(surName);
            binding.ageStudnet.setText(age);
        }
    }
}