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

import adapter.adapter_post;
import adapter.post_itam;

public class Home extends AppCompatActivity {
    ActivityHomeBinding binding;

    List<post_itam> postItamList =new ArrayList<>();
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
       binding.RecyclerViewHome.setAdapter(adapterPost);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false );
       binding.RecyclerViewHome.setLayoutManager(linearLayoutManager);
    }
}