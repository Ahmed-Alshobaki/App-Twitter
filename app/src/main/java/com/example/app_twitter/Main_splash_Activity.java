package com.example.app_twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.app_twitter.databinding.ActivitySplashMainBinding;

public class Main_splash_Activity extends AppCompatActivity {
    ActivitySplashMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding =ActivitySplashMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Thread thread =new Thread() {

            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(Main_splash_Activity.this, SignIn.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }


        };
        thread.start();
    }
}