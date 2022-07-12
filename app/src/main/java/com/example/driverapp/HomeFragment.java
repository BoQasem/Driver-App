package com.example.driverapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.example.driverapp.data.model.StudentList;

public class HomeFragment extends Fragment {
    TextView showStudentBt;
    Button startTripBt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showStudentBt = view.findViewById(R.id.show_present);
        startTripBt = view.findViewById(R.id.start_trip);
//        showStudentBt.setText(String.valueOf(StudentList.size));
        showStudentBt.setText("5");
        showStudentBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(),StudentsActivity.class);
                startActivity(intent);
            }
        });

        startTripBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(),MapsActivity2.class);
                startActivity(intent);
            }
        });



//        logout = logout.findViewById(R.id.logoutBtn);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("remember","false");
//                editor.apply();
//                finish();
//            }
//        });
        super.onViewCreated(view, savedInstanceState);
    }
}
