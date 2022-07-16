package com.example.driverapp.ui.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.driverapp.R;

public class MessageDetails extends AppCompatActivity {

    private Bundle data;
    private TextView title;
    private TextView date;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_bar)));

        title = findViewById(R.id.title);
        date  = findViewById(R.id.date);
        message = findViewById(R.id.message_view);
        data = getIntent().getExtras();

        if(data != null) {
            title.setText(String.format("Title : %s", data.getString("title")));
            date.setText(String.format("Date : %s", data.getString("date")));
            message.setText(String.format("\n%s", data.getString("message")));
        }
    }
}