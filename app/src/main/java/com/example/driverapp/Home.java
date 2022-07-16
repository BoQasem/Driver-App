package com.example.driverapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.driverapp.ui.chat.Inbox;
import com.example.driverapp.ui.chat.Outbox;
import com.example.driverapp.ui.chat.SendMessage;
import com.example.driverapp.ui.fragment.HomeFragment;
import com.example.driverapp.ui.fragment.LogoutFragment;
import com.example.driverapp.ui.fragment.ProfileFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    Toolbar toolbar;
    ConstraintLayout button_bell;

//    Button withParentBn;
//    NotificationCounter notificationCounter;
    DrawerLayout mainLayout;
//    Button logout;
//    Button showStudentBt;

    public void snackBar(View v){
        Snackbar.make(mainLayout,"student will be absent.",Snackbar.LENGTH_LONG)
                .setAction("Close",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                    }
                })
                .setActionTextColor(getResources().getColor(R.color.purple_200)).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
                toolbar.setTitle("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_inbox:
                toolbar.setTitle("Inbox");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Inbox()).commit();
                break;
            case R.id.nav_outbox:
                toolbar.setTitle("Outbox");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Outbox()).commit();
                break;
            case R.id.nav_send:
                toolbar.setTitle("Send to parent");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SendMessage()).commit();
                break;
            case R.id.nav_profile:
                toolbar.setTitle("Profile");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LogoutFragment()).commit();
                break;

        }
        drawer .closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mainLayout = findViewById(R.id.drawer_layout);

//        button_bell = findViewById(R.id.bell);
//        button_bell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                getSupportActionBar().setTitle("Inbox");
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.drawer_layout,new Inbox()).commit();
//            }
//        });
//        notificationCounter = new NotificationCounter(findViewById(R.id.bell));
       // withParentBn = findViewById(R.id.button_with_parent);

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//        withParentBn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(Home.this,"My Notification");
//                builder.setContentTitle("Absence of a student");
//                builder.setContentText("Student Mohammed Qasem will be absent today");
//                builder.setSmallIcon(R.drawable.ic_notification);
//                builder.setAutoCancel(true);
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Home.this);
//                managerCompat.notify(1,builder.build());
//
//                notificationCounter.increaseNumber();
////                snackBar(view);
//            }
//        });

        toolbar = findViewById(R.id.toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }



//        logout = findViewById(R.id.logoutBtn);
//        showStudentBt = findViewById(R.id.showStudent);
//
//        showStudentBt.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this,StudentsActivity.class);
//                startActivity(intent);
//            }
//        });
//
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
    }
}