package com.example.fugapormexico;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private  static final  String Tag = "recyclerView";
    private Context mContext;
    private ArrayList<Messages> messagesList;
    public RecyclerAdapter(Context mcontext, ArrayList<Messages> messagesList) {
        this.mContext = mcontext;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item,parent,false);
        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(messagesList.get(position).getName());
        Glide.with(mContext)
                .load(messagesList.get(position).getImageUrl())
                .into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = imageView.findViewById(R.id.imageView);
            textView = imageView.findViewById(R.id.textView);
        }
    }
}
