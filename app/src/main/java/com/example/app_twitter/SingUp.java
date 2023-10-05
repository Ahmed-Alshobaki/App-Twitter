package com.example.app_twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.app_twitter.databinding.ActivitySingUpBinding;

public class SingUp extends AppCompatActivity {
        ActivitySingUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding =ActivitySingUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
       binding.SignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplication(),SignIn.class);
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
               binding.name.setBackgroundResource(R.drawable.sign_1);
               binding.Usersname.setBackgroundResource(R.drawable.sign_1);
               binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });
        binding.Usersname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_1);
                binding.Usersname.setBackgroundResource(R.drawable.sign_2);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_2);
                binding.Usersname.setBackgroundResource(R.drawable.sign_1);
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
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_1);
                binding.Usersname.setBackgroundResource(R.drawable.sign_1);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}