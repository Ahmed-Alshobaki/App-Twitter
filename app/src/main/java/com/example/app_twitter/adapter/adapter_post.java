package com.example.app_twitter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_twitter.Database.Database1;
import com.example.app_twitter.R;
import com.example.app_twitter.databinding.CustomPostBinding;
import com.example.app_twitter.users.user;

import java.util.List;

public class adapter_post extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<post_itam> postItamList ;
    CustomPostBinding binding;
    boolean likePost=false;
    Database1 database1 ;



    public adapter_post(Context context, List<post_itam> postItamList,Database1 Database) {
        this.context = context;
        this.postItamList = postItamList;
        this.database1 = Database;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CustomPostBinding.inflate(LayoutInflater.from(context),parent,false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myViewHolder   myViewHolder = (myViewHolder) holder;
        myViewHolder.binding.textbody.setText(postItamList.get(position).textbody);
        myViewHolder.binding.textLikeNumber.setText(String.valueOf(postItamList.get(position).like));
        myViewHolder.binding.usesname.setText("@"+postItamList.get(position).username);
        myViewHolder.binding.name.setText(postItamList.get(position).name);
        myViewHolder.binding.time.setText(postItamList.get(position).time);
        myViewHolder.binding.imageheart.setOnClickListener(new View.OnClickListener() {
          //  user user=  database1.getUserByUsername(postItamList.get(position).username,Database1.COLUMN_New_Username);
            @Override
            public void onClick(View view) {
          if (likePost==false){
              likePost=true;
              myViewHolder.binding.imageheart.setImageResource(R.drawable.likepost);

          }else {
              likePost=false;
              myViewHolder.binding.imageheart.setImageResource(R.drawable.likepostred);
          }

            }
        });
     //   myViewHolder.binding.textbody.setText(postItamList.get(position).textbody);

    }

    @Override
    public int getItemCount() {
        return postItamList.size();
    }
    class  myViewHolder extends  RecyclerView.ViewHolder {
        CustomPostBinding binding;
        public myViewHolder(CustomPostBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}
