package com.example.driverapp.data.model;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.driverapp.R;
import com.example.driverapp.StudentsActivity;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class StudentList extends ArrayAdapter<Student> {

    public static int size = 0;

//    public void setSize(Context context,ArrayList<Student> studentArrayList) {
//        this.size = studentArrayList.size();
//    }

    public StudentList(Context context, ArrayList<Student> studentArrayList){
        super(context, R.layout.list_student,studentArrayList);
        size = studentArrayList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student obj = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_student,parent,false);
        }
        TextView firstName = convertView.findViewById(R.id.first_name);
        TextView lastName = convertView.findViewById(R.id.last_name);
        TextView surName = convertView.findViewById(R.id.surname);
        TextView age = convertView.findViewById(R.id.age);
//        TextView absence = convertView.findViewById(R.id.absence);

        firstName.setText(obj.fist_name);
        lastName.setText(obj.last_name);
        surName.setText(obj.surname);
        age.setText(obj.age);
//        absence.setEnabled(obj.absence);

        return convertView;
//        return super.getView(position, convertView, parent);
    }

}
