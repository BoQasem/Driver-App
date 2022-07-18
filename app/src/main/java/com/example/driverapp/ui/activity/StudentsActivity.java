package com.example.driverapp.ui.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.driverapp.R;
import com.example.driverapp.model.Student;
import com.example.driverapp.model.StudentList;
import com.example.driverapp.databinding.ActivityStudentsBinding;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity {

    ActivityStudentsBinding binding;
    public static ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_bar)));
        String[] firstName = {"Micheal","Matthew","James","Francis","William"};
        String[] lastName = {"William","Robert","lan","Shaun","lan"};
        String[] surName = {"Ellitott","Tiffany","Volz","Bennett","Bradshaw"};
        String[] age = {"8","11","8","9","9"};
//        boolean[] absence = {false,false,false,false,true};

        for(int i=0; i<firstName.length; i++){
            Student obj = new Student(firstName[i],lastName[i],surName[i],age[i]);
            studentArrayList.add(obj);
        }

        StudentList objects = new StudentList(StudentsActivity.this,studentArrayList);
        binding.listview.setAdapter(objects);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(StudentsActivity.this,ProfileActivity.class);
                intent.putExtra("first_name",firstName[i]);
                intent.putExtra("last_name",lastName[i]);
                intent.putExtra("sur_name",surName[i]);
                intent.putExtra("age",age[i]);
                startActivity(intent);
            }
        });

    }
}