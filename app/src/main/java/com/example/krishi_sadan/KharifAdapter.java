package com.example.krishi_sadan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.Model.kharifRecycle;

import java.util.List;

public class KharifAdapter  extends RecyclerView.Adapter<KharifAdapter.KharifViewHolder> {

    List<kharifRecycle> kharifList;

    public KharifAdapter(List<kharifRecycle> kharifList) {
        this.kharifList=kharifList;
    }

    @NonNull
    @Override
    public KharifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kharif_grid,parent,false);
        KharifViewHolder kharifViewHolder =new KharifViewHolder(view);
        return new KharifViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KharifAdapter.KharifViewHolder holder, int position) {

        holder.kharif_name.setText(kharifList.get(position).getName());
        holder.kharif_img.setImageResource(kharifList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return kharifList.size();
    }

    public class KharifViewHolder extends RecyclerView.ViewHolder {

        TextView kharif_name;
        ImageView kharif_img;
        public KharifViewHolder(@NonNull View itemView) {
            super(itemView);
            kharif_img=itemView.findViewById(R.id.kharif_img);
            kharif_name=itemView.findViewById(R.id.kharif_name);
        }
    }
}
