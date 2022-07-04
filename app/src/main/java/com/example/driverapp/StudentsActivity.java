package com.example.driverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.driverapp.data.model.Student;
import com.example.driverapp.data.model.StudentList;
import com.example.driverapp.databinding.ActivityMainBinding;
import com.example.driverapp.databinding.ActivityStudentsBinding;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity {

    ActivityStudentsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String[] firstName = {"Abdo","monzer","taqi","mohmed","mosa"};
        String[] lastName = {"ahmed","mohmed","eshaq","qasem","mohmed"};
        String[] surName = {"alimi","hamed","maiof","saleh","mo"};
        String[] age = {"22","23","23","21","20"};
//        boolean[] absence = {false,false,false,false,true};

        ArrayList<Student> studentArrayList = new ArrayList<>();
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