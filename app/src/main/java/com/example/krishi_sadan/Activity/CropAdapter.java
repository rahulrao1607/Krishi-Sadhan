package com.example.krishi_sadan.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.Model.CropRecycle;
import com.example.krishi_sadan.R;

import java.util.List;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.CropViewHolder> {

    List<CropRecycle> cropList;

    private onRecyclerViewClickListener listener;

    public interface onRecyclerViewClickListener
    {
        void OnItemClick(int position);
    }

    public void onRecyclerViewClickListener(onRecyclerViewClickListener listener)
    {
        this.listener=listener;
    }

    public CropAdapter(List<CropRecycle> cropList)
    {
        this.cropList=cropList;
    }

    @NonNull
    @Override
    public CropViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cropgrid,parent,false);
        return new CropViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CropViewHolder holder, int position) {

        holder.crop_name.setText(cropList.get(position).getName());
        holder.crop_img.setImageResource(cropList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return cropList.size();
    }



    public class CropViewHolder extends RecyclerView.ViewHolder{

        TextView crop_name;
        ImageView crop_img;

        public CropViewHolder(@NonNull View itemView,onRecyclerViewClickListener listener) {
            super(itemView);

            crop_name =itemView.findViewById(R.id.crop_name);
            crop_img =itemView.findViewById(R.id.crop_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null && getAdapterPosition()!=RecyclerView.NO_POSITION)
                    {
                        listener.OnItemClick(getAdapterPosition());
                    }

                }
            });

        }
    }
}
