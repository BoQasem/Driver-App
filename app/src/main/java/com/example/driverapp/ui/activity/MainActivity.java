package com.example.driverapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.driverapp.Home;
import com.example.driverapp.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static int LOGIN_CODE = 1234;
    private List<AuthUI.IdpConfig> providers;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener listener;

    Handler handler = new Handler();
    public void run_activity(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
    private void delaySplashScreen2(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable,2*1000);
    }

//    private void init(){
//        providers = Arrays.asList(new AuthUI.IdpConfig.PhoneBuilder().build());
//        firebaseAuth = FirebaseAuth.getInstance();
//        listener = myFirebaseAuth ->{
//            FirebaseUser user = myFirebaseAuth.getCurrentUser();
//            if(user != null)
//                delaySplashScreen2();
//            else
//                showLoginLayout();
//        };
//    }
//
//    private void showLoginLayout() {
//        AuthMethodPickerLayout authMethodPickerLayout = new AuthMethodPickerLayout
//                .Builder(R.layout.layout_login)
//                .setPhoneButtonId(R.id.ic_phone)
//                .build();
//        startActivityForResult(AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAuthMethodPickerLayout(authMethodPickerLayout)
//                .setIsSmartLockEnabled(false)
//                .setAvailableProviders(providers)
//                .build(),LOGIN_CODE);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == LOGIN_CODE){
//            IdpResponse response = IdpResponse.fromResultIntent(data);
//            if(resultCode == RESULT_OK){
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            }else{
//                Toast.makeText(this,"[ERROR]: " +response.getError().getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        firebaseAuth.addAuthStateListener(listener);
//    }
//
//    @Override
//    protected void onStop() {
//        if(firebaseAuth != null && listener != null)
//            firebaseAuth.removeAuthStateListener(listener);
//        super.onStop();
//    }

    private void delaySplashScreen(){
//        Completable.timer(5, TimeUnit.SECONDS,
//                AndroidSchedulers.mainThread())
//                .subscribe(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Toast.makeText(MainActivity.this, "Splash screen done", Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();  // hide bar
        delaySplashScreen2();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, Home.class);
//                startActivity(intent);
//                finish();
//            }
//        };
//        handler.postDelayed(runnable,2*1000);
//        init();
    }
}