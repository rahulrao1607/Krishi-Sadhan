package com.example.krishi_sadan.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.Activity.allcropactivity.Animal_crop;
import com.example.krishi_sadan.Activity.allcropactivity.Decrotive_Crops;
import com.example.krishi_sadan.Activity.allcropactivity.Fruit_crop;
import com.example.krishi_sadan.Activity.allcropactivity.Kharif_crop;
import com.example.krishi_sadan.Activity.allcropactivity.Rabi_crops;
import com.example.krishi_sadan.Activity.allcropactivity.Spices_crops;
import com.example.krishi_sadan.Activity.allcropactivity.Vegetable_crop;
import com.example.krishi_sadan.Model.CropRecycle;
import com.example.krishi_sadan.R;
import com.example.krishi_sadan.databinding.ActivityDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends DrawerbaseActivity {
    ActivityDashboardBinding activityDashboardBinding;
    FirebaseAuth auth;
    RecyclerView croprecycle , newsrecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding =ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");


        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(Dashboard.this, Signup.class));
        }

        // news recycle
        newsrecycle = findViewById(R.id.newsrecylce);
        newsrecycle.setHasFixedSize(true);
        newsrecycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<Integer> newsrecycle1 = new ArrayList<>();

        newsrecycle1.add(R.drawable.banner1);
        newsrecycle1.add(R.drawable.banner2);
        newsrecycle1.add(R.drawable.news1);

        newsAdapter newsadapter=new newsAdapter(newsrecycle1);
        newsrecycle.setAdapter(newsadapter);


        /// crop recycle


        croprecycle = findViewById(R.id.cropsrecycle);
        croprecycle.setHasFixedSize(true);
        croprecycle.setLayoutManager(new GridLayoutManager(this,2));



        List<CropRecycle> cropRecycles = new ArrayList<>();

        cropRecycles.add(new CropRecycle(R.drawable.kharif , "Kahrif Crop"));
        cropRecycles.add(new CropRecycle(R.drawable.fruit , "Fruits Crop"));
        cropRecycles.add(new CropRecycle(R.drawable.animal , "Animal"));
        cropRecycles.add(new CropRecycle(R.drawable.spices , "Spices"));
        cropRecycles.add(new CropRecycle(R.drawable.flower , "Decorative Flowers"));
        cropRecycles.add(new CropRecycle(R.drawable.vegii , "Vegetable"));
        cropRecycles.add(new CropRecycle(R.drawable.rabi,"Rabi crops"));


        CropAdapter cropAdapter=new CropAdapter(cropRecycles);
        croprecycle.setAdapter(cropAdapter);


        // starting new activity for each of the grid layout
        cropAdapter.onRecyclerViewClickListener(new CropAdapter.onRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {
                //Toast.makeText(Dashboard.this, "Poistion: "+position, Toast.LENGTH_SHORT).show();
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(Dashboard.this, Kharif_crop.class));
                        break;
                    case 1:
                        startActivity(new Intent(Dashboard.this, Fruit_crop.class));
                        break;
                    case 2:
                        startActivity(new Intent(Dashboard.this, Animal_crop.class));
                        break;
                    case 3:
                        startActivity(new Intent(Dashboard.this, Spices_crops.class));
                        break;
                    case 4:
                        startActivity(new Intent(Dashboard.this, Decrotive_Crops.class));
                        break;
                    case 5:
                        startActivity(new Intent(Dashboard.this, Vegetable_crop.class));
                        break;
                    case 6:
                        startActivity(new Intent(Dashboard.this, Rabi_crops.class));
                        break;
                }
            }
        });

    }


}