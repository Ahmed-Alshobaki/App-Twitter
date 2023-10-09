package com.example.app_twitter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDateTime;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.app_twitter.Database.Database1;
import com.example.app_twitter.adapter.post_itam;
import com.example.app_twitter.databinding.ActivityAddPostBinding;
import com.example.app_twitter.databinding.ActivityHomeBinding;
import com.example.app_twitter.users.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Add_post extends AppCompatActivity {
    ActivityAddPostBinding binding;
    Database1 database1 ;
    SharedPreferences preferencesE_p ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        preferencesE_p =  getSharedPreferences("my_preferences",MODE_PRIVATE);
        LocalDateTime currentDateTime = LocalDateTime.now();
        database1 = new Database1(this);
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
        binding.textbody.addTextChangedListener(new TextWatcher() {
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
        binding.Tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post_itam post_itam =new post_itam();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);
                String emailORusername = preferencesE_p.getString("emailORusername", "null");
                if (containsAtSymbol(emailORusername)){
                    user user =   database1.getUserByUsername(emailORusername,Database1.COLUMN_New_Email);
                    post_itam.setName(user.getName());
                    System.out.println(formattedDateTime);
                    post_itam.setLike(0);
                    post_itam.setTime(String.valueOf(formattedDateTime));
                    post_itam.setUsername(user.getUsername());
                    post_itam.setTextbody(binding.textbody.getText().toString());
                    database1.insertPost(post_itam);
                }else {
                    user user =  database1.getUserByUsername(emailORusername,Database1.COLUMN_New_Username);
                    post_itam.setName(user.getName());
                    post_itam.setLike(0);
                    post_itam.setTime(String.valueOf(formattedDateTime));
                    post_itam.setUsername(user.getUsername());
                    post_itam.setTextbody(binding.textbody.getText().toString());
                    database1.insertPost(post_itam);
                    System.out.println(user.getUsername());
                }



            }
        });
    }
    public boolean containsAtSymbol(String text) {
        return text != null && text.contains("@");
    }

}