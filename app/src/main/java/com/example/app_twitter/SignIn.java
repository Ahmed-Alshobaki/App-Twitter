package com.example.app_twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.app_twitter.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {
        ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplication(), SingUp.class);
            startActivity(intent);
            }
        });
        binding.EmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_2);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_2);
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}