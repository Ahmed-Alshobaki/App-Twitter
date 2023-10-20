package com.example.app_twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_twitter.databinding.ActivityForgotPasswordBinding;

public class ForgotPassword extends AppCompatActivity {
    ActivityForgotPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.NextToNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this, new_password.class);
                startActivity(intent);
                finish();
            }
        });
    }
}