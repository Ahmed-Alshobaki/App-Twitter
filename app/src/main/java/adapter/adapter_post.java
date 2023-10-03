package adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_twitter.databinding.CustomPostBinding;

import java.util.ArrayList;
import java.util.List;

public class adapter_post extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<post_itam> postItamList ;
    CustomPostBinding binding;


    public adapter_post(Context context, List<post_itam> postItamList) {
        this.context = context;
        this.postItamList = postItamList;
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
