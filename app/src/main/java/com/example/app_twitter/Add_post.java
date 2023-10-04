package com.example.app_twitter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.app_twitter.databinding.ActivityAddPostBinding;
import com.example.app_twitter.databinding.ActivityHomeBinding;

public class Add_post extends AppCompatActivity {
    ActivityAddPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.Addimage2.setVisibility(View.GONE);
        binding.Remove.setVisibility(View.GONE);
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getData()!=null) {
                    Uri uri = result.getData().getData();
                    binding.imageView.setImageURI(uri);
                    binding.imageView.setVisibility(View.VISIBLE);
                    binding.Remove.setVisibility(View.VISIBLE);
                    binding.Addimage2.setVisibility(View.VISIBLE);
                    binding.Addimage.setVisibility(View.GONE);
                }
                if (result.getData()==null) {
                    binding.Addimage2.setVisibility(View.GONE);
                    binding.imageView.setVisibility(View.GONE);
                    binding.Remove.setVisibility(View.GONE);
                }

            }
        });
        binding.Addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                binding.imageView.setVisibility(View.GONE);
                activityResultLauncher.launch(intent);

            }
        });
        binding.Addimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                activityResultLauncher.launch(intent);

            }
        });
        binding.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.Addimage2.setVisibility(View.GONE);
                binding.imageView.setVisibility(View.GONE);
                binding.Remove.setVisibility(View.GONE);
                binding.Addimage.setVisibility(View.VISIBLE);
            }
        });
        binding.EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    binding.Tweet.setBackgroundResource(R.drawable.buttom_add2);
                }else {
                    binding.Tweet.setBackgroundResource(R.drawable.buttom_add);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplication(),Home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}