package com.example.krishi_sadan.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.R;

import java.util.List;


public class newsAdapter extends RecyclerView.Adapter<newsAdapter.NewsViewHolder> {
    private List<Integer> imageList;

    public newsAdapter(List<Integer> imageList){
        this.imageList= imageList;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsgrid , parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.mImageView.setImageResource(imageList.get(position));

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.news_1);
        }
    }
}


