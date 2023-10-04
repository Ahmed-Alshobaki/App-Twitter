package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_twitter.databinding.CustomImagStoryBinding;

import java.util.List;

public class adapter_image extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    CustomImagStoryBinding binding;
    Context context ;
    List<image_itam> imgeItamList;

    public adapter_image(Context context, List<image_itam> imgeItamList) {
        this.context = context;
        this.imgeItamList = imgeItamList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CustomImagStoryBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.binding.name.setText(imgeItamList.get(position).name);
        int maxLength = 7;

        if (imgeItamList.get(position).name.length() <= maxLength) {
            viewHolder.binding.name.setText(imgeItamList.get(position).name);
        } else {
            String truncatedText = imgeItamList.get(position).name.substring(0, maxLength);
            viewHolder.binding.name.setText(truncatedText + "..");
        }
    }

    @Override
    public int getItemCount() {
        return imgeItamList.size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder{
        CustomImagStoryBinding binding;
        public ViewHolder( CustomImagStoryBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
}
