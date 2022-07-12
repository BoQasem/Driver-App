package com.example.driverapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
//    Button rateButton;
//    RatingBar ratingStars;
//    float myRating = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        rateButton = view.findViewById(R.id.button_rat);
//        ratingStars = view.findViewById(R.id.ratingBar);
//
//        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                myRating = ratingBar.getRating();
//            }
//        });
//
//        rateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ProfileFragment.this.getActivity(), String.valueOf(myRating), Toast.LENGTH_SHORT).show();
//            }
//        });

        super.onViewCreated(view, savedInstanceState);
    }
}
