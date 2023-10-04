package com.example.app_twitter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.app_twitter.databinding.ActivityHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import adapter.adapter_image;
import adapter.adapter_post;
import adapter.image_itam;
import adapter.post_itam;

public class Home extends AppCompatActivity {
    ActivityHomeBinding binding;

    List<post_itam> postItamList =new ArrayList<>();
    List<image_itam> image_itamList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        postItamList.add(new post_itam("ahmed", "Ahmed zon", "ondoiasndias", "10",17));
        postItamList.add(new post_itam("ahmed", "Ahmed zon", "ondoiasndias", "6",80));
        postItamList.add(new post_itam("ahmed", "Ahmed zon", "ondoiasndias", "6",80));
        postItamList.add(new post_itam("ahmed", "Ahmed zon", "ondoiasndias", "6",80));
        adapter_post adapterPost = new adapter_post(getBaseContext(),postItamList);
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
    }
}