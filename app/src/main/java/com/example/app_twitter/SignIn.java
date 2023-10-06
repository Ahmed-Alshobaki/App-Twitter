package com.example.app_twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;

import com.example.app_twitter.Database.Database1;
import com.example.app_twitter.databinding.ActivitySignInBinding;
import com.example.app_twitter.users.user;

public class SignIn extends AppCompatActivity {
    ActivitySignInBinding binding;
    Database1 database1 = new Database1(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
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
        binding.LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.EmailEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();
                if (email.isEmpty()) {
                    binding.EmailEditText.setError("Please enter an email");
                }
                if (password.isEmpty()) {
                    binding.passwordEditText.setError("Please enter an Password");
                }
                if (checkLogin(email,password)){
                    Intent  intent = new Intent(SignIn.this,Home.class);
                    startActivity(intent);
                }
            }
        });
    }

    @SuppressLint("Range")
    public boolean checkLogin(String Email, String Password) {
        Cursor cursor = database1.getCursor();
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex(Database1.COLUMN_New_Email)).equals(Email)) {
                if (cursor.getString(cursor.getColumnIndex(Database1.COLUMN_New_Password)).equals(Password)) {
                    return true;
                }
            }

        }
        return false;
    }


}