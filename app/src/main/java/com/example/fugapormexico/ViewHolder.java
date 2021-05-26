package com.example.fugapormexico;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(View itemView){
        super(itemView);
        mView = itemView;
    }

    public void setDetails(Context ctx, String title, String description, String image){
        //views
        TextView mTitleView = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        //set data to views
        mTitleView.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageIv);
    }

}