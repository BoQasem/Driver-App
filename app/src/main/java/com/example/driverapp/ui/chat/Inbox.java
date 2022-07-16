package com.example.driverapp.ui.chat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.driverapp.R;
import com.example.driverapp.controller.MessageAdapter;
import com.example.driverapp.databinding.FragmentInboxBinding;
import com.example.driverapp.model.Message;
import com.example.driverapp.network.ApiClient;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inbox extends Fragment {

    private FragmentInboxBinding binding;
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private ArrayList<Message> messageList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInboxBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        messageList = new ArrayList<>();

        messageAdapter = new MessageAdapter(root.getContext(), messageList);
        recyclerView = root.findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(messageAdapter);
        fillData();

        return root;
    }

    @SuppressLint("NotifyDataSetChanged")
    void fillData(){

//        try {
//            SharedPreferences sharedPreferences = getContext().getSharedPreferences("IM_IN",0);
//            int userId = sharedPreferences.getInt("id",-1);
//            ApiClient.getUserService().inbox(userId).enqueue(new Callback<ArrayList<Message>>() {
//                @Override
//                public void onResponse(Call<ArrayList<Message>> call, Response<ArrayList<Message>> response) {
//
//                    if (response.isSuccessful()) {
//                        Log.d("log in : ", "success");
//                        Log.d("status : ", "i got the data ");
//
//                        if(response.body() != null) {
//                            Log.d("status : ", "i got the data ");
//                            for(int i = 0; i < response.body().size(); i++){
//                                messageList.add(response.body().get(i));
//                            }
//                            messageAdapter.notifyDataSetChanged();
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ArrayList<Message>> call, Throwable t) {
//                    Log.d("log in : ", "failed and didn't get the data");
//                    Log.e("error is : ", t.toString());
//                }
//            });
//        }
//        catch (Exception e) {
//            Log.e("error", e.toString());
//        }
        Date d = new Date();

        messageList.add(new Message("4","slow down your speed !", "I can see you in the map driving too fast and you got kids with you so slow down or I will report to the school principal","Sat Jul 16 11:29:14 GMT+02:00 2022"));
        messageAdapter.notifyDataSetChanged();
    }
}