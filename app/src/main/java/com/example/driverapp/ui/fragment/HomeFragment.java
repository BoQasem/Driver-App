package com.example.driverapp.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.driverapp.ui.activity.AbsentActivity;
import com.example.driverapp.ui.activity.MapsActivity;
import com.example.driverapp.R;
import com.example.driverapp.ui.activity.StudentsActivity;

public class HomeFragment extends Fragment {
    TextView showStudentBt;
    TextView button_absent;
    Button startTripBt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showStudentBt = view.findViewById(R.id.show_present);
        button_absent = view.findViewById(R.id.absence);
        startTripBt = view.findViewById(R.id.start_trip);
//        showStudentBt.setText(String.valueOf(StudentList.size));


        showStudentBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), StudentsActivity.class);
                startActivity(intent);
            }
        });

        button_absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), AbsentActivity.class);
                startActivity(intent);
            }
        });
        showStudentBt.setText("5");
        startTripBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), MapsActivity.class);
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
