package com.example.app_twitter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.app_twitter.Database.Database1;
import com.example.app_twitter.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.app_twitter.adapter.adapter_image;
import com.example.app_twitter.adapter.adapter_post;
import com.example.app_twitter.adapter.image_itam;
import com.example.app_twitter.adapter.post_itam;


public class Home extends AppCompatActivity {
    ActivityHomeBinding binding;


    List<image_itam> image_itamList =new ArrayList<>();
    @SuppressLint("NewApi")
    Database1 database1 = new Database1(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

       adapter_post adapterPost = new adapter_post(getBaseContext(),database1.getPostList(),database1);
       binding.RecyclerViewHomePost.setAdapter(adapterPost);
        LinearLayoutManager linearLayoutManagerPost = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false );
       binding.RecyclerViewHomePost.setLayoutManager(linearLayoutManagerPost);
        //
        adapter_image adapter_image = new adapter_image(getBaseContext(),image_itamList);
        LinearLayoutManager linearLayoutManagerImage = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false );
        binding.RecyclerViewHomeImage.setLayoutManager(linearLayoutManagerImage);
        binding.RecyclerViewHomeImage.setAdapter(adapter_image);
        image_itamList.add(new image_itam("Ahvvvvvvvvmedzon"));
        image_itamList.add(new image_itam("Hala"));
        image_itamList.add(new image_itam("Zon"));
        image_itamList.add(new image_itam("Zon"));
        image_itamList.add(new image_itam("Zon"));
        image_itamList.add(new image_itam("Ahmed zon"));
        image_itamList.add(new image_itam("Hala"));
        binding.addFloatingactionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), Add_post.class);
                startActivity(intent);
            }
        });
    }
}